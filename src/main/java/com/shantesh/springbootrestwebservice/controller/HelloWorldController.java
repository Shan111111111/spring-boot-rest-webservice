package com.shantesh.springbootrestwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String sayHello(){
        return "Hi Welcome to Hello world .....";
    }


}
