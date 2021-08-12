package com.example.demo.service;

import com.example.demo.dao.MenuDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.RestaurantDao;
import com.example.demo.entity.MenuEntity;
import com.example.demo.entity.OrderTableEntity;
import com.example.demo.entity.RestaurantEntity;
import com.example.demo.request.FinalOrder;
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

    public OrderTableResponse saveFinalOrder(FinalOrder order){
        orderDao.deleteAll();
        List<OrderTableEntity> list=order.getItemArray();

        for(OrderTableEntity value:list){
            OrderTableEntity orderTableEntity=new OrderTableEntity();
            orderTableEntity.setName(value.getName());
            orderTableEntity.setPrice(value.getPrice());
            orderDao.save(orderTableEntity);
        }
        OrderTableResponse orderTableResponse=new OrderTableResponse();
        orderTableResponse.setId(200);
        return orderTableResponse;
    }

}
