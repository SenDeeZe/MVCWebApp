package org.example.services;

import org.example.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.entities.Order;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void create(Order order) {
        orderRepository.save(order);
    }


    public Order findById(Integer id) {
        return orderRepository.getById(id);
    }


    public void update(Order order) {
        orderRepository.save(order);
    }


    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }


    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}
