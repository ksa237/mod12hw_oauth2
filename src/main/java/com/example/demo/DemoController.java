package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

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

}
