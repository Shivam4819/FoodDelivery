package com.example.demo.dao;

import com.example.demo.entity.OrderTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderTableEntity, Integer> {
}
