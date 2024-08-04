package com.course.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.api.models.Order;
import com.course.api.records.OrderRecord;

@RestController
public class FirstController {

    @GetMapping("/hellow")
    public String sayHello() {
        return "Hello momo!";
    }
    @GetMapping("/hellow/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello "+ name;
    }
    

    @GetMapping("/hello")
    public String displayString(@RequestParam String firstname, @RequestParam String lastname) {
        return "Hello "+ firstname + " " + lastname;
    }

    @PostMapping("/post")
    public String postSomething(@RequestBody String body) {
        return "You posted: " + body;
    }

    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order) {
        return "You posted: " + order.toString();
    }
    @PostMapping("/post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord order) {
        return "You posted: " + order.toString();
    }
}
