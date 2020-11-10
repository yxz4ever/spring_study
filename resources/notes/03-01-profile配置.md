# profile配置

## 1. 配置profile bean

1. @Profile注解指定某个bean属于哪一个profile,只有profile激活的时候,才会创建对应的bean

    ```java
    package com.xrluo.javaConfig;
    
    import com.xrluo.classes.ProfileDemo;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Profile;
    
    @Configuration
    @ComponentScan(basePackageClasses = ProfileDemo.class)
    public class JavaBean {
    
    
        @Profile("dev")
        @Bean
        public ProfileDemo test1(){
            ProfileDemo demo = new ProfileDemo();
    
            demo.setSt("当前profile是dev");
    
            return demo;
        }
    
    
        @Profile("prod")
        @Bean
        public ProfileDemo test2(){
    
            ProfileDemo demo = new ProfileDemo();
    
            demo.setSt("当前profile是prod");
    
            return demo;
        }
    
    }
    ```

2. xml中配置profile,在<beans>标签内加入profile <beans profiles="xxxxxx"> 可以嵌套<beans>标签

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
        <beans profile="dev">
            <bean id="test1" class="com.xrluo.classes.ProfileDemo" >
                <property name="st" value="dev环境" />
            </bean>
        </beans>
    
    
        <beans profile="prod" >
            <bean id="test1" class="com.xrluo.classes.ProfileDemo" >
                <property name="st" value="prod环境" />
            </bean>
        </beans>
    </beans>
    ```

3. 源代码模块:03-profile-01-profile

4. 备注:如果测试的时候不加入@ActiveProfiles 会报错误

    ```java
    No qualifying bean of type 'com.xrluo.classes.ProfileDemo' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    ```

    



## 2. 激活profile

### 1. 确定那个profile处于激活需要依赖两个独立属性

1. spring.profiles.active
2. spring.profiles.default

### 2. 主次

优先查找active设置的属性,如果没有,再次查找default,均没有的话,就只会创建那些没有定义在profile中的bean

### 3. 多种方式来设置这两个属性

1. 作为DispatcherServlet的初始化参数.
2. 作为web应用的上下文参数 
3. 作为JNDI条目
4. 作为环境变量
5. 作为JVM的系统属性
6. 在集成测试类上,使用@ActiveProfiles注解设置

## 3.条件化Bean

1. 使用@Conditional注解,它可以用到代用@bean注解的方法上,如果给定的条件计算结果为true,就会创建这个bean,否则的话,这个bean就会被忽略.

2. ```java
    package com.xrluo.javaConfig;
    
    import com.xrluo.condition.EnvExistsCondition;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Conditional;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class JavaBean3 {
    
        @Bean
        @Conditional(EnvExistsCondition.class)
        public String test1(){
            return "测试...............";
        }
    }
    ```

3. ```java
    package com.xrluo.condition;
    
    import org.springframework.context.annotation.Condition;
    import org.springframework.context.annotation.ConditionContext;
    import org.springframework.core.type.AnnotatedTypeMetadata;
    
    public class EnvExistsCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            // Environment environment = context.getEnvironment();
            // return environment.containsProperty("dev");
            return true;
        }
    }
    ```

4. 通过ConditionContext,我们可以做到如下几点:

    1. 借助getRegistry()返回的BeanDefinitionRegistry检查bean定义.
    2. 借助getBeanFactory()fanhui de COnfigurableListabLeBeanFactory检查bean是否存在,甚至探查bean的属性.
    3. 借助getEnvironment()返回的Environment检查环境变量是否存在以及它的值是什么.
    4. 读取病探查getResourceLoader()返回的ResourceLoader所加载的资源.
    5. 借助getClassLoader()返回的ClassLoader加载并检查类是否存在

5. AnnotatedTypeMetadata则能够让我们检查带有@Bean注解的方法上还有什么其他的注解.

6. ```java
    /*
     * Copyright 2002-2018 the original author or authors.
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *      https://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
    
    package org.springframework.context.annotation;
    
    import org.springframework.core.env.Profiles;
    import org.springframework.core.type.AnnotatedTypeMetadata;
    import org.springframework.util.MultiValueMap;
    
    /**
     * {@link Condition} that matches based on the value of a {@link Profile @Profile}
     * annotation.
     *
     * @author Chris Beams
     * @author Phillip Webb
     * @author Juergen Hoeller
     * @since 4.0
     */
    class ProfileCondition implements Condition {
    
       @Override
       public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
          MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
          if (attrs != null) {
             for (Object value : attrs.get("value")) {
                if (context.getEnvironment().acceptsProfiles(Profiles.of((String[]) value))) {
                   return true;
                }
             }
             return false;
          }
          return true;
       }
    
    }
    ```

7. 此处环境变量spring.profiles.active没有加明白,所以只是简单测试了一下  **源代码模块:03-profile-01-profile**



## 4. 处理自动装配的歧义性

1. 标示首选的bean (primary)  @Primary 
    1. 用法  与@Component  和 @Bean一起使用
    2. xml中 使用primary属性   primary="true"
    3. 弊端:当同一类型的bean,使用@Primary数量超过一个时,我们并没有其他办法缩小范围
2. 限定自动装配   限定符(@Qualifier)
    1. 用法: 它可以与@Autowired 和@Inject协同使用
    2. 例如: @Qualifier("iceCream")参数就是要注入的bean的ID
    3. 弊端:如果重构了类名,会导致注入失败
3. 创建自定义的限定符
    1. 用法:与@Component或@Bean使用,意为为bean指定限定符名称,不用担心重构类名的问题
4. 使用自定义限定符
    1. 想使用多个限定符注解的时候,我们可以自定义注解,上面使用@Qualifier("xxxx")注解就可以.



## 5. bean的作用域

1. 单例:整个应用中,只创建bean的一个实例(默认)
2. 原型:每次注入或通过Spring应用上下文获取的时候都会创建一个新的bean实例.
3. 会话:在web应用中,每个会话创建一个bean实例
4. 请求,在web应用中,为每个请求创建一个bean实例
5. <span style="color:red">此处重点部分在于如何应用到实际情况当中.留待后续补充@TODO</span>



## 6. 注入外部值

1. @PropertySource("classpath:/com/xxx/xxx.properties") 外部配置文件(数据源)
2. 使用Environment.getProperty("xxxx")获取属性值
3. 使用@Value("xxxx") 获取属性值



## 7. 属性占位符

${...}   

<span style="color:red" >留待后续补充@TODO</span>

## 8.SpEL表达式

#{...}

<span style="color:red" >留待后续补充@TODO</span>