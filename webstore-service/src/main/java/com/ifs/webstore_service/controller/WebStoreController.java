package com.ifs.webstore_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebStoreController {

    @GetMapping("/health")
    public String health() {
        return "Webstore Service OK";
    }

    @PostMapping("/checkout")
    public String checkout() {
        return "Checkout received";
    }
}