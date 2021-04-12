package org.example.services;

import org.example.entities.Order;
import org.example.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        order = new Order();
        order.setId(1);
        order.setClient("Ivan");
        order.setDate("22.06.2005");
        order.setAddress("Stachki");
    }

    @Test
    void findById_Should_Return_Order() {
        when(orderRepository.getById(1)).thenReturn(order);
        Order newOrder = orderService.findById(1);
        assertEquals(order, newOrder);
        Mockito.verify(orderRepository, Mockito.times(1)).getById(anyInt());
    }
    @Test
    void findById_Should_Return_Null() {
        when(orderRepository.getById(5)).thenReturn(null);
        Order newOrder = orderService.findById(5);
        assertThat(newOrder).isNull();
        Mockito.verify(orderRepository, Mockito.times(1)).getById(anyInt());
    }


}