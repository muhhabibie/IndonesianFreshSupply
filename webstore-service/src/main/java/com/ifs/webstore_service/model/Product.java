package com.ifs.webstore_service.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String name;
    private String category;
    private Integer price;
    private Integer stock;
    private String supplierId;
    private String supplierName;
}