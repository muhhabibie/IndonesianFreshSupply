package com.ifs.webstore_service.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private String cartId;
    private String buyerId;
    private List<CartItem> items = new ArrayList<>();
    private Integer totalPrice = 0;
}