package com.example.demo.request;

import com.example.demo.entity.OrderTableEntity;
import lombok.Data;

import java.util.List;

@Data
public class FinalOrder {

    private List<OrderTableEntity> itemArray;

}
