package com.example.demo.response;

import lombok.Data;

@Data
public class CartItemResponse {
    private int id;
    private int itemid;
    private String name;
    private int price;
}
