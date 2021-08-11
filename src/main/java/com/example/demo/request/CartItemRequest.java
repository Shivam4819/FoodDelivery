package com.example.demo.request;

import lombok.Data;

@Data
public class CartItemRequest {
    private int itemid;
    private String name;
    private int price;
}
