package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Data
@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;





    @GetMapping("/user/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }




    }

