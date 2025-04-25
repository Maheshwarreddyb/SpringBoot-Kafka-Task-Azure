package com.inn.kafkatask.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inn.kafkatask.springboot.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inn.kafkatask.springboot.service.KafkaOrderProducer;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private KafkaOrderProducer producer;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) throws JsonProcessingException {
        producer.sendOrder(order);
        return ResponseEntity.ok("Order placed and sent to Kafka");
    }
}
