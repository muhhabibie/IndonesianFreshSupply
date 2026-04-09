package com.ifs.payment_service.config.producer;

import com.ifs.payment_service.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String EXCHANGE = "order.exchange";
    private final String ROUTING_KEY = "payment.processed";

    public void sendPaymentProcessed(Order order) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
        System.out.println("Payment processed event sent for order: " + order.getOrderId());
    }
}