package com.shantesh.springbootrestwebservice.bean;

public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
