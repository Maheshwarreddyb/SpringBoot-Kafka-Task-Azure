package com.inn.kafkatask.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.kafkatask.springboot.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "order-topic";

    public void sendOrder(Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String orderJson = mapper.writeValueAsString(order);
        kafkaTemplate.send(topic, orderJson);
    }

}
