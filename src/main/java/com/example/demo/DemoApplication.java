package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

    @GetMapping("/hi")
    public String hi() {
        return "Hi!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }

    @GetMapping("/read")
    public String read() {
        return "Read.";
    }

    @GetMapping("/write")
    public String write() {
        return "Write.";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
