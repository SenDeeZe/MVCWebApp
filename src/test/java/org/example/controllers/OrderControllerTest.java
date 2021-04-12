package org.example.controllers;

import org.example.entities.Order;
import org.example.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    Order order;
    List<Order> orders;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Order order = new Order();
        order.setId(1);
        order.setClient("Ivan");
        order.setDate("22.06.2005");
        order.setAddress("Stachki");
        orders = Arrays.asList(order);
    }

    @Test
    void orderPage() {
        when(orderService.getAll()).thenReturn(orders);
        ModelAndView modelAndView = orderController.orderPage();
        assertEquals("orderPage", modelAndView.getViewName());
        assertEquals(orders ,modelAndView.getModel().get("orderList"));
        Mockito.verify(orderService, Mockito.times(1)).getAll();
    }

    @Test
    void findOrderPage() {
        when(orderService.findById(1)).thenReturn(order);
        ModelAndView modelAndView = orderController.findOrderPage(1);
        assertEquals("findOrderPage", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("findOrderPage"));
        Mockito.verify(orderService, Mockito.times(1)).findById(anyInt());
    }

    @Test
    void orderUpdatePage() {
        when(orderService.findById(1)).thenReturn(order);
        ModelAndView modelAndView = orderController.orderUpdatePage(1);
        assertEquals("orderUpdatePage", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("orderUpdatePage"));
        Mockito.verify(orderService, Mockito.times(1)).findById(anyInt());
    }

    @Test
    void updateOrder() {
        ModelAndView modelAndView = orderController.updateOrder(order);
        assertEquals("redirect:/order", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("redirect:/order"));
        Mockito.verify(orderService, Mockito.times(1)).update(Mockito.eq(order));
    }

    @Test
    void addOrderPage() {
        ModelAndView modelAndView = orderController.addOrderPage();
        assertEquals("orderUpdatePage", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("orderUpdatePage"));
    }

    @Test
    void addOrder() {
        ModelAndView modelAndView = orderController.addOrder(order);
        assertEquals("redirect:/order", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("redirect:/order"));
        Mockito.verify(orderService, Mockito.times(1)).create(Mockito.eq(order));
    }

    @Test
    void deleteOrder() {
        ModelAndView modelAndView = orderController.deleteOrder(1);
        assertEquals("redirect:/order", modelAndView.getViewName());
        assertEquals(order, modelAndView.getModel().get("redirect:/order"));
        Mockito.verify(orderService, Mockito.times(1)).delete(anyInt());
    }


}