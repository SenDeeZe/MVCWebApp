package org.example.services;

import org.example.entities.Order;
import org.example.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
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
    void findById() {
        int index = 1;

        when(orderRepository.getById(index)).thenReturn(order);

        Order newOrder = orderService.findById(index);
        assertEquals(order, newOrder);
        verify(orderRepository, Mockito.times(1)).getById(index);
    }

    @Test
    void findByIdNull() {
        Order newOrder = orderService.findById(5);

        assertNull(newOrder);
        verify(orderRepository, Mockito.times(1)).getById(anyInt());
    }


    @Test
    void create() {
        orderService.create(order);
        verify(orderRepository, Mockito.times(1)).save(Mockito.eq(order));
    }

    @Test
    void update() {
        orderService.update(order);
        verify(orderRepository, Mockito.times(1)).save(Mockito.eq(order));
    }

    @Test
    void delete() {
        int index = 1;
        orderService.delete(index);
        verify(orderRepository, Mockito.times(1)).deleteById(index);
    }

    @Test
    void getAll() {
        List<Order> list = Collections.singletonList(order);

        Mockito.when(orderRepository.findAll()).thenReturn(list);

        List<Order> resultList = orderService.getAll();

        Order resultOrder = resultList.get(0);

        assertEquals(list.size(), resultList.size());
        assertEquals(order.getId(), resultOrder.getId());
        assertEquals(order.getClient(), resultOrder.getClient());
        assertEquals(order.getAddress(), resultOrder.getAddress());
        assertEquals(order.getDate(), resultOrder.getDate());

        verify(orderRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getAllEmpty() {
        List<Order> list = Collections.emptyList();

        when(orderRepository.findAll()).thenReturn(list);

        assertEquals(list.size(), orderService.getAll().size());

        verify(orderRepository, Mockito.times(1)).findAll();
    }
}