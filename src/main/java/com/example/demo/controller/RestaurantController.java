package com.example.demo.controller;

import com.example.demo.request.FinalOrder;
import com.example.demo.request.MenuIdRequest;
import com.example.demo.response.*;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/get")
    public List<RestaurantListResponse> resturantlist(){

        return restaurantService.fetchlist();
    }

    @PostMapping("/menus")
    public List<MenuListResponse> fetchMenu(@RequestBody MenuIdRequest menuIdRequest){
       return restaurantService.getMenu(menuIdRequest.getId());
    }

    @GetMapping("/finalorder")
    public List<FinalOrderResponse> finalOrder(){
        return restaurantService.fetchFinalOrder();
    }

    @PostMapping("/placeOrder")
    public OrderTableResponse placeOrder(@RequestBody FinalOrder order){
        return restaurantService.saveFinalOrder(order);
    }

}
