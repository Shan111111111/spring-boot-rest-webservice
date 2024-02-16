package com.shantesh.springbootrestwebservice.controller;

import com.shantesh.springbootrestwebservice.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String sayHello(){
        return "Hi Welcome to Hello world .....";
    }

    @GetMapping("/hello-bean")
    public HelloWorldBean sayHelloByReturningBeanYaObject(){
        return new HelloWorldBean("Hi Welcome to Hello world .....");
    }

    @GetMapping("/hello-bean/path-variable/{name}")
    public HelloWorldBean sayHelloByReturningBeanYaObject(@PathVariable String name){
        return new HelloWorldBean(String.format("Hi man welcome, you came by path variable --> %s", name));
    }


    @GetMapping("/hello-world-internationalized")
    public String sayHelloInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message", null,  locale);
    }

}
