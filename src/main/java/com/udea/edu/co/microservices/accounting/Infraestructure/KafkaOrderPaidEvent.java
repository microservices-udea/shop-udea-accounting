package com.udea.edu.co.microservices.accounting.Infraestructure;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaOrderPaidEvent implements EventConsumer {

    @Override
    @KafkaListener(topics = "orderPaid")
    public void processEvent(String message) {
        System.out.println("event:" + message);
    }
}
