package com.ifs.oms_service.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifs.oms_service.model.Order;
import com.ifs.oms_service.producer.OrderProducer;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        orderProducer.sendOrder(order);
        return "Pesanan diterima dan sedang diproses!";
    }
}