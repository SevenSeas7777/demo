package com.example.demo.controller;

import com.example.demo.service.ReminderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {
    @Autowired
    private ReminderProducer reminderProducer;

    @GetMapping("/sendReminder")
    public String sendReminder(@RequestParam String message) {
        reminderProducer.sendReminder(message);
        return "Reminder sent: " + message;
    }
}
