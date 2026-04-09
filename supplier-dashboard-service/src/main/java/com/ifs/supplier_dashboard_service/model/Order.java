package com.ifs.supplier_dashboard_service.model;

import lombok.Data;

@Data
public class Order {
    private String orderId;
    private String buyerId;
    private String buyerName;
    private String buyerEmail;
    private String shippingAddress;
    private Integer totalAmount;
    private String status;
}