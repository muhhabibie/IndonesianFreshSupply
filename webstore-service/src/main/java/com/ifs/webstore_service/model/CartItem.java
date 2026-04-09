package com.ifs.webstore_service.model;

import lombok.Data;

@Data
public class CartItem {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer price;
}