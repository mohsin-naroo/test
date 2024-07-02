package com.redmath.training.lecture01.helloworld;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/v1/hello-world")
    public ResponseEntity<Map<String, Object>> helloWorld() {
        return ResponseEntity.ok(Map.of("message", "Hello World!", "at", LocalDateTime.now()));
    }
}
