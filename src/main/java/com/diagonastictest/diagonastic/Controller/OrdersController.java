package com.diagonastictest.diagonastic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Service.PatientsService;

@RestController
public class OrdersController {
    
    @Autowired
    PatientsService o;

    @PostMapping("/addOrder")
    public Orders addOrder(@RequestBody Orders orders){

        return o.addOrder(orders);
    }
}
