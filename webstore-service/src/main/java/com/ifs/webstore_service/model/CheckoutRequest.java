package com.ifs.webstore_service.model;

import lombok.Data;
import java.util.List;

@Data
public class CheckoutRequest {
    private String buyerId;
    private String buyerName;
    private String buyerEmail;
    private String buyerPhone;
    private String shippingAddress;
    private List<CartItem> items;
    private Integer totalAmount;
    private String paymentMethod;
}