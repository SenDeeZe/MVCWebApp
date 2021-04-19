package org.example.controllers;

import org.example.entities.Order;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class RestOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Order> orderPage() {
        return orderService.getAll();
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") int id) {
        orderService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Order findOrderPage(@PathVariable("id") int id) {
        return orderService.findById(id);
    }
}
