package com.mvadly.spring_restful.repository;

import com.mvadly.spring_restful.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    // JpaRepository provides built-in methods like findAll(), findById(), save(), etc.
}
