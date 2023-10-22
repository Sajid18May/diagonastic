package com.diagonastictest.diagonastic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Repo.ORepo;

@Service
public class OrdersService {
    @Autowired
    ORepo orepo;

    public Orders addOrder(Orders orders) {
        return orepo.save(orders);
    }

    public List<Orders> fetchAllOrders() {
        return orepo.findAll();
    }

    public Orders getOrdersById(int id) {
        Optional<Orders> order = orepo.findById(id);

        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public String deleteOrdersById(int id) {
        if (orepo.findById(id).isPresent()) {
            orepo.deleteById(id);
            return "order deleted successfully";
        }
        return "No such order in the database";
    }

}
