package com.example.demo.controller;

import com.example.demo.component.Person;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private Person person;

    @Autowired
    private HelloService helloService;
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(person);
        System.out.println(helloService.getFirstname());
        return "hello word!";
    }
}
