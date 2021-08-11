package com.example.demo.controller;

import com.example.demo.request.CartItemRequest;
import com.example.demo.request.DeleteCartItemRequest;
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

    @PostMapping("/order")
    public AddToCartResponse addmenu(@RequestBody CartItemRequest cartItemRequest){

      return restaurantService.addToCart(cartItemRequest);
    }

    @GetMapping("/cart")
    public List<CartItemResponse> cartItem(){

        return restaurantService.getCartItem();
    }

    @PostMapping("/delcart")
    public DeleteCartItemResponse deleteItem(@RequestBody DeleteCartItemRequest deleteCartItemRequest){
         return restaurantService.delFromCart(deleteCartItemRequest);

    }

    @PostMapping("/placeOrder")
    public OrderTableResponse placeOrder(){
       return restaurantService.storeOder();
    }

    @GetMapping("/finalorder")
    public List<FinalOrderResponse> finalOrder(){
        return restaurantService.fetchFinalOrder();
    }

}
