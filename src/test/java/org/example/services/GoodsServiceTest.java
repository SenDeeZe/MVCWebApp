package org.example.services;

import org.example.entities.Goods;
import org.example.entities.Order;
import org.example.repositories.GoodsRepository;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GoodsServiceTest {

    @InjectMocks
    private GoodsService goodsService;

    @Mock
    private GoodsRepository goodsRepository;

    private Goods goods;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        goods = new Goods();
        goods.setId(1);
        goods.setName("Apple");
        goods.setPrice(100.0);
    }

    @Test
    void create() {
        goodsService.create(goods);
        verify(goodsRepository, Mockito.times(1)).save(Mockito.eq(goods));
    }

    @Test
    void findById() {
        int index = 1;

        when(goodsRepository.getById(index)).thenReturn(goods);

        Goods newGoods = goodsService.findById(index);
        assertEquals(goods, newGoods);
        verify(goodsRepository, Mockito.times(1)).getById(index);
    }

    @Test
    void findByIdNull() {
        Goods newGoods = goodsService.findById(5);

        assertNull(newGoods);
        verify(goodsRepository, Mockito.times(1)).getById(anyInt());
    }

    @Test
    void update() {
        goodsService.update(goods);
        verify(goodsRepository, Mockito.times(1)).save(Mockito.eq(goods));
    }

    @Test
    void delete() {
        int index = 1;
        goodsService.delete(index);
        verify(goodsRepository, Mockito.times(1)).deleteById(index);
    }

    @Test
    void getAll() {
        List<Goods> list = Collections.singletonList(goods);

        Mockito.when(goodsRepository.findAll()).thenReturn(list);

        List<Goods> resultList = goodsService.getAll();

        Goods resultGoods = resultList.get(0);

        assertEquals(list.size(), resultList.size());
        assertEquals(goods.getId(), resultGoods.getId());
        assertEquals(goods.getName(), resultGoods.getName());
        assertEquals(goods.getPrice(), resultGoods.getPrice());

        verify(goodsRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getAllEmpty() {
        List<Goods> list = Collections.emptyList();

        when(goodsRepository.findAll()).thenReturn(list);

        assertEquals(list.size(), goodsService.getAll().size());

        verify(goodsRepository, Mockito.times(1)).findAll();
    }
}