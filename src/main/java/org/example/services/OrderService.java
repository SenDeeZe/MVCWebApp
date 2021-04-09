package org.example.services;

import org.example.entities.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);
    Order read(int id);
    void update(Order order);
    void delete(Integer id);
    List<Order> getAll();
}
