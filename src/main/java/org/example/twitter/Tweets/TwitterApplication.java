package org.example.twitter.Tweets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class TwitterApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TwitterApplication.class, args);
    }
}



//{"id":1,"userName":"Ryomen Sukuna","tweet":"Yooooo","loggedIn":false}
//        {"id":2,"userName":"The Strongest","tweet":"Yooooo","loggedIn":false}
//        {"id":3,"userName":"Toji Fushiguro","tweet":"Yooooo","loggedIn":false}
//        {"id":4,"userName":"Maki Zenin","tweet":"Yooooo","loggedIn":false}
//        {"id":5,"userName":"The Strongest","tweet":"Yooooo","loggedIn":false}
//        {"id":1,"userName":"Megumi Fushiguro","tweet":"Yooooo","loggedIn":true}
//        {"id":2,"userName":"Kenjaku","tweet":"Yooooo","loggedIn":true}
