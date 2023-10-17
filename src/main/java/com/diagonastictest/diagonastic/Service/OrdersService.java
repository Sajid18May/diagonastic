package com.diagonastictest.diagonastic.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Repo.ORepo;

public class OrdersService {
    @Autowired
    ORepo orepo;
    public Orders addOrder(Orders orders){
        return orepo.save(orders);
    }
}
