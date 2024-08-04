package com.course.api;

import org.springframework.stereotype.Component;

@Component
public class HellowWorld {

     private final String myVar;

    public HellowWorld(String myVar) {
        this.myVar = myVar;
    }
    public String sayHello() {
        return "Hello momo! ==> myVar: " + myVar;
    }
}
