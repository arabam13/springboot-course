package com.course.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    // private final HellowWorld hellowWorld;

    // public FirstService(HellowWorld hellowWorld) {
    //     this.hellowWorld = hellowWorld;
    // }
    @Autowired
    // @Qualifier("hellowWorld")
    private HellowWorld hellowWorld;

    public String tellStory() {
        return "the dependancy is saying => " + hellowWorld.sayHello();
    }
}
