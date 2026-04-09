package com.ifs.oms_service.config.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ifs.oms_service.model.Order;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "order.created.queue")
    public void handleOrderCreated(Order order) {
        System.out.println("Order diterima di OMS: " + order.getOrderId());
        // Di sini nanti akan diproses dan dikirim ke Inventory & Payment
    }
}