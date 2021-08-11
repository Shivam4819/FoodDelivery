package com.example.demo.service;

import com.example.demo.dao.CartDao;
import com.example.demo.dao.MenuDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.RestaurantDao;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.MenuEntity;
import com.example.demo.entity.OrderTableEntity;
import com.example.demo.entity.RestaurantEntity;
import com.example.demo.request.CartItemRequest;
import com.example.demo.request.DeleteCartItemRequest;
import com.example.demo.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    public List<RestaurantListResponse> fetchlist(){
        List<RestaurantEntity> list=restaurantDao.findAll();
        List<RestaurantListResponse>restaurantListResponses=new ArrayList<>();

        for (RestaurantEntity restaurantEntity:list){
            RestaurantListResponse restaurantListResponse=new RestaurantListResponse();
            restaurantListResponse.setId(restaurantEntity.getId());
            restaurantListResponse.setName(restaurantEntity.getName());
            restaurantListResponse.setAddress(restaurantEntity.getAddress());
            restaurantListResponse.setPhone(restaurantEntity.getPhone());

            restaurantListResponses.add(restaurantListResponse);
        }
        return restaurantListResponses;
    }

    public List<MenuListResponse> getMenu(int id){
        List<MenuEntity> list=menuDao.findByRestId(id);
        List<MenuListResponse>menuListResponses=new ArrayList<>();

        for (MenuEntity menuEntity:list){
            MenuListResponse menuListResponse=new MenuListResponse();
            menuListResponse.setId(menuEntity.getId());
            menuListResponse.setName(menuEntity.getName());
            menuListResponse.setPrice(menuEntity.getPrice());
            menuListResponse.setRest_id(menuEntity.getRestId());

            menuListResponses.add(menuListResponse);
        }
        return menuListResponses;
    }

    public AddToCartResponse addToCart(CartItemRequest cartItemRequest){
        try {
            CartEntity cartEntity = new CartEntity();
            cartEntity.setItemid(cartItemRequest.getItemid());
            cartEntity.setName(cartItemRequest.getName());
            cartEntity.setPrice(cartItemRequest.getPrice());
            cartDao.save(cartEntity);
            orderDao.deleteAll();
            AddToCartResponse addToCartResponse=new AddToCartResponse();
            addToCartResponse.setCode(200);
            return addToCartResponse;
        }catch (Exception exception){
            AddToCartResponse addToCartResponse=new AddToCartResponse();
            addToCartResponse.setCode(400);
            return addToCartResponse;
        }

    }

    public List<CartItemResponse> getCartItem(){
        List<CartEntity> list=cartDao.findAll();
        List<CartItemResponse>cartItemResponses=new ArrayList<>();

        for (CartEntity cartEntity:list){
            CartItemResponse cartItemResponse=new CartItemResponse();
            cartItemResponse.setId(cartEntity.getId());
            cartItemResponse.setName(cartEntity.getName());
            cartItemResponse.setPrice(cartEntity.getPrice());
            cartItemResponse.setItemid(cartEntity.getItemid());

            cartItemResponses.add(cartItemResponse);
        }
        return cartItemResponses;
    }

    public DeleteCartItemResponse delFromCart(DeleteCartItemRequest deleteCartItemRequest){
        try {
            cartDao.deleteById(deleteCartItemRequest.getId());
            DeleteCartItemResponse deleteCartItemResponse=new DeleteCartItemResponse();
            deleteCartItemResponse.setCode(200);
            return deleteCartItemResponse;
        }catch (Exception exception){
            System.out.println("exception--"+exception);
            DeleteCartItemResponse deleteCartItemResponse=new DeleteCartItemResponse();
            deleteCartItemResponse.setCode(400);
            return deleteCartItemResponse;
        }

    }
    public OrderTableResponse storeOder(){
     List <CartEntity> list=cartDao.findAll();

       for (CartEntity cartEntity: list){
           OrderTableEntity orderTableEntity=new OrderTableEntity();
           orderTableEntity.setName(cartEntity.getName());
           orderTableEntity.setPrice(cartEntity.getPrice());

           orderDao.save(orderTableEntity);
       }
       cartDao.deleteAll();
        OrderTableResponse orderTableResponse=new OrderTableResponse();
        orderTableResponse.setId(200);
        return orderTableResponse;
    }

    public List<FinalOrderResponse> fetchFinalOrder(){
        List<OrderTableEntity> list=orderDao.findAll();
        List<FinalOrderResponse>finalOrderResponses=new ArrayList<>();

        for (OrderTableEntity orderTableEntity:list){
            FinalOrderResponse finalOrderResponse=new FinalOrderResponse();
            finalOrderResponse.setName(orderTableEntity.getName());
            finalOrderResponse.setPrice(orderTableEntity.getPrice());

            finalOrderResponses.add(finalOrderResponse);
        }
        return finalOrderResponses;
    }
}
