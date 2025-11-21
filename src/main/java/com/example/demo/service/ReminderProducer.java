package com.example.demo.service;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ReminderProducer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendReminder(String message){
        Message<String> build = MessageBuilder.withPayload("Hello,RocketMQ").build();
        rocketMQTemplate.convertAndSend("ReminderTopic",build);
    }
}
