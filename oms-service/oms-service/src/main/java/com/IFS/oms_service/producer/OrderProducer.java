package com.ifs.oms_service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ifs.oms_service.model.Order;

@Service
public class OrderProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {
        // Mengirim pesan ke exchange [cite: 1012]
        rabbitTemplate.convertAndSend(exchange, "", order);
        System.out.println("Pesanan dikirim ke RabbitMQ: " + order.getOrderId());
    }
}