# Spring实战 第一章概览

针对**第4版**读

## 1. 基本概念

### 1.1 EJB 企业级JavaBean

​	Enterprise Java Beans

### 1.2 POJO 简单老式Java对象

​	Plain Old Java Object

### 1.3 DI 依赖注入

​	Dependency Injection

### 1.4 AOP 面向切面编程

​	Aspect Oriented Programming

### 1.5 IOC 控制反转

​	Inversion of Control

### 1.6 容器



##  2. Spring采取以下4种关键策略

### 2.1 基于POJO的轻量级和最小侵入性编程

### 2.2 通过依赖注入和面向接口实现松耦合

### 2.3 基于切面和惯例进行声明式编程

### 2.4 通过切面和模板减少样板式代码



## 3. 依赖注入

### 3.1 构造器注入(constructor injection) 构造方法传参

​	Spring 表达式语言(Spring Expression Language) 例如:#{T(System).out}



## 4. 容器

### 4.1 BeanFactory 接口(使用到的很少)

### 4.2 应用上下文ApplicationContext接口

​	4.2.1 AnnotationConfigApplicationContext 从一个或多个基于Java的配置类中加载Spring应用上下文

​	4.2.2 AnnotationConfigWebApplicationContext 从一个或多个基于Java的配置类中加载Spring Web应用上下文

​	4.2.3 ClassPathXmlApplicationContext 从类路径下的一个或多个XML配置文件中加载上下文定义,把应用上下文的定义文件作为类资源.

​	4.2.4 FileSystemXmlApplicationContext 从文件系统下的一个或多个XML配置文件中加载上下文定义

​	4.2.5 XmlWebApplicationContext 从web应用下的一个或多个XML配置文件中加载上下文定义



## 5. Bean的生命周期

1. Spring对bean进行实例化
2. Spring将值和bean的引用注入到bean对应的属性中
3. 如果bean实现了BeanNameAware接口,Spring将对bean的ID传递给setBeanName()方法
4. 如果bean实现了BeanFactoryAware接口,Spring将调用setBeanFactory()方法,将BeanFactory容器实例传入.
5. 如果bean实现了ApplicationContextAware接口,将调用setApplicationContext()方法,将bean所在的应用上下文的引用传入进来
6. 如果bean实现了BeanPostProcessor接口,将调用他们的postProcessBeforeInitialization()方法
7. 如果bean实现了InitializingBean接口,将调用他们的afterPropertiesSet()发方法,如果bean使用了init-method声明了初始化方法,该方法也会被调用.
8. 如果bean实现了BeanPostProcessor接口,将调用postProcessAfterInitialization()方法
9. 此时bean已经准备就绪,可以被该应用程序使用了,它们将一直主流在应用上下文中,知道该应用上下文被销毁.
10. 如果bean实现了DisposableBean接口,Spring将调用它的destroy()接口方法,同样如果bean使用destory-method声明了,销毁方法,该方法也会被调用.



## 6. Spring 模块(依据所属的功能可以划分为6类不同的功能)

### 1. 测试

1. spring-test

### 2. Spring核心容器

1. spring-beans
2. spring-core
3. spring-context
4. spring-expression
5. spring-context-support

### 3. 面向切面编程(AOP)

1. spring-aop
2. spring-aspects

### 4. Instrumentation

1. spring-instrument
2. spring-instrument-tomcat

### 5. 数据访问与集成

1. spring-jdbc
2. spring-transaction
3. spring-orm
4. spring-oxm
5. spring-messaging
6. spring-jms

### 6. Web与远程调用

1. spring-web
2. spring-web-servlet
3. spring-web-portlet
4. spring-websocket