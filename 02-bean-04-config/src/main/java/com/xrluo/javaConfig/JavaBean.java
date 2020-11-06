package com.xrluo.javaConfig;

import com.xrluo.classes.Song;
import com.xrluo.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBean {

    @Autowired
    private Song song;

    @Bean
    public Song song() {
        Song song = new Song();
        song.setName("笑傲江湖");
        song.setAuthor("令狐冲");
        return song;
    }

    // @Bean
    // public User user(){
    //     return new User(song());
    // }

    @Bean
    public User user() {
        return new User(song);
    }

}
