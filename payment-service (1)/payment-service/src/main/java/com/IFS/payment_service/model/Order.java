package com.IFS.payment_service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L; // Penting untuk pengiriman pesan [cite: 908]
    private String orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime orderDate;
}