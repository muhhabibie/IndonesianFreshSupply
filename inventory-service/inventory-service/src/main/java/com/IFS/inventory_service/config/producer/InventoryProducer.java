package com.ifs.inventory_service.config.producer;

import com.ifs.inventory_service.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String EXCHANGE = "order.exchange";
    private final String ROUTING_KEY = "stock.reserved";

    public void sendStockReserved(Order order) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
        System.out.println("Stock reserved event sent for order: " + order.getOrderId());
    }
}