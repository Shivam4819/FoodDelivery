package com.example.demo.response;

import lombok.Data;

@Data
public class RestaurantListResponse {
    private int id;
    private long phone;
    private String name;
    private String address;
}
