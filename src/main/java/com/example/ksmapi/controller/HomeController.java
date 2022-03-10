package com.example.ksmapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm")
public class HomeController {
    @GetMapping("")
    public String home(){
        return "Welcome on KSM";
    }

}
