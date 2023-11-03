package com.diagonastictest.diagonastic.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Service.OrdersService;

@Controller
public class OWController {
    @Autowired
    OrdersService repository;
    
      @GetMapping("/order")
    public String getData(Model model) {
        List <Orders> data = repository.fetchAllOrders() ;
        model.addAttribute("dataList", data);
        return "order"; 
    }
}
