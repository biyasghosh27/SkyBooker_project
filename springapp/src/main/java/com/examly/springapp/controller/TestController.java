package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/test/welcome")
    public ResponseEntity<String> testWelcomeApi (){
        String s = "Welcome to the Flight Booking Application";
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }
}
