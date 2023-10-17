package com.diagonastictest.diagonastic.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diagonastictest.diagonastic.Entity.Orders;

public interface ORepo extends JpaRepository<Orders,Integer>{
    
}
