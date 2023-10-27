package com.diagonastictest.diagonastic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Service.OrdersService;

@RestController
public class OrdersController {
    
    @Autowired
    OrdersService o;

    @PostMapping("/addOrder")
    public Orders addOrder(@RequestBody Orders orders){

        return o.addOrder(orders);
    }
    
	  @GetMapping("/getOrders")
	    public List<Orders> getAllOrders() {
	        return o.fetchAllOrders();
	    }
	  
	  @GetMapping("/getOrders/{id}") //localhost:8080/getOrders/5
	  public Orders getOrdersById(@PathVariable("id")int id)
	  {
		  return o.getOrdersById(id);
	  }
	  
	  @DeleteMapping("/Orders/{id}")
	  public String deleteOrders(@PathVariable("id") int id) {
		  return o.deleteOrdersById(id);
	  }
}
