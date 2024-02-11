package com.shantesh.springbootrestwebservice.controller;

import com.shantesh.springbootrestwebservice.bean.HelloWorldBean;
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

    @GetMapping("/hello-bean")
    @ResponseBody
    public HelloWorldBean sayHelloByReturningBeanYaObject(){
        return new HelloWorldBean("Hi Welcome to Hello world .....");
    }



}
