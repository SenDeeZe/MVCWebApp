package org.example.controllers;

import org.example.entities.Goods;
import org.example.entities.Order;
import org.example.services.GoodsService;
import org.example.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class GoodsControllerTest {

    @InjectMocks
    GoodsController goodsController;

    @Mock
    GoodsService goodsService;

    Goods goods;
    List<Goods> goodsList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Goods goods = new Goods();
        goods.setId(1);
        goods.setName("Apple");
        goods.setPrice(100.0);
        goodsList = Arrays.asList(goods);
    }

    @Test
    void goodsPage() {
        when(goodsService.getAll()).thenReturn(goodsList);
        ModelAndView modelAndView = goodsController.goodsPage();
        assertEquals("goodsPage", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("goodsPage"));
        Mockito.verify(goodsService, Mockito.times(1)).getAll();
    }

    @Test
    void findGoodsPage() {
        when(goodsService.findById(1)).thenReturn(goods);
        ModelAndView modelAndView = goodsController.findGoodsPage(1);
        assertEquals("findGoodsPage", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("findGoodsPage"));
        Mockito.verify(goodsService, Mockito.times(1)).findById(anyInt());
    }

    @Test
    void goodsUpdatePage() {
        when(goodsService.findById(1)).thenReturn(goods);
        ModelAndView modelAndView = goodsController.goodsUpdatePage(1);
        assertEquals("goodsUpdatePage", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("goodsUpdatePage"));
        Mockito.verify(goodsService, Mockito.times(1)).findById(anyInt());
    }

    @Test
    void updateGoods() {
        ModelAndView modelAndView = goodsController.updateGoods(goods);
        assertEquals("redirect:/goods", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("redirect:/goods"));
        Mockito.verify(goodsService, Mockito.times(1)).update(Mockito.eq(goods));
    }

    @Test
    void addGoodsPage() {
        ModelAndView modelAndView = goodsController.addGoodsPage();
        assertEquals("goodsUpdatePage", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("goodsUpdatePage"));
    }

    @Test
    void addGoods() {
        ModelAndView modelAndView = goodsController.addGoods(goods);
        assertEquals("redirect:/goods", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("redirect:/goods"));
        Mockito.verify(goodsService, Mockito.times(1)).create(Mockito.eq(goods));
    }

    @Test
    void deleteGoods() {
        ModelAndView modelAndView = goodsController.deleteGoods(1);
        assertEquals("redirect:/goods", modelAndView.getViewName());
        assertEquals(goods, modelAndView.getModel().get("redirect:/goods"));
        Mockito.verify(goodsService, Mockito.times(1)).delete(anyInt());
    }
}