package io.marble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        System.out.println("启动中");
        SpringApplication.run(BlogApplication.class, args);
    }
}
