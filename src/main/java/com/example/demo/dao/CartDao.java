package com.example.demo.dao;

import com.example.demo.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<CartEntity, Integer> {
}
