package com.shantesh.springbootrestwebservice.controller;

import com.shantesh.springbootrestwebservice.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

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



}
