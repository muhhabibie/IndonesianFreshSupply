package com.ifs.supplier_dashboard_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @GetMapping("/health")
    public String health() {
        return "Supplier Dashboard OK";
    }

    @GetMapping("/orders/incoming")
    public String getIncomingOrders() {
        return "List of incoming orders";
    }
}