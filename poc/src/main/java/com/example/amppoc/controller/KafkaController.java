package com.example.amppoc.controller;

import com.example.amppoc.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
   @Autowired
    KafkaProducerService producerService;


    @GetMapping("/produce/{message}")
    public String produceMessage(@PathVariable String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka: " + message;
    }
}

