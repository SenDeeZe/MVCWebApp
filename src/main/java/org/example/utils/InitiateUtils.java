package org.example.utils;

import lombok.RequiredArgsConstructor;
import org.example.entities.Goods;
import org.example.entities.Order;
import org.example.services.GoodsService;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;


    @Override
    public void run(String... args) throws Exception {
            Order order1 = new Order();
            Order order2 = new Order();
            order1.setClient("sgdfgfg");
            order1.setDate("gfsdg");
            order1.setAddress("gsdggasrg");
            order2.setClient("Ivan");
            order2.setDate("20");
            order2.setAddress("Sta");
            orderService.save(order1);
            orderService.save(order2);
            for (Order order: orderService.getAll())
                System.out.println(order);
            Goods goods1 = new Goods();
            goods1.setName("peach");
            goods1.setPrice(231.0);
            goodsService.save(goods1);
            for (Goods goods: goodsService.getAll())
                System.out.println(goods);
    }
}