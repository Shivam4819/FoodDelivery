package com.example.demo.dao;

import com.example.demo.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDao extends JpaRepository<RestaurantEntity, Integer> {
}
