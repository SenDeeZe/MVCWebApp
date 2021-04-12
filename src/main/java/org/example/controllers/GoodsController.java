package org.example.controllers;

import org.example.entities.Goods;
import org.example.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView goodsPage() {
        List<Goods> goods = goodsService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsPage");
        modelAndView.addObject("goodsList", goods);
        return modelAndView;
    }
    @RequestMapping(value = "/find/", method = RequestMethod.POST)
    public ModelAndView findOrderPage(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Goods goods = goodsService.findById(id);
        modelAndView.setViewName("findGoodsPage");
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView goodsUpdatePage(@PathVariable("id") Integer id) {
        Goods goods = goodsService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsUpdatePage");
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateGoods(@ModelAttribute("goods") Goods goods) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        goodsService.update(goods);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addGoodsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsUpdatePage");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addGoods(@ModelAttribute("order") Goods goods) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        goodsService.create(goods);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGoods(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        goodsService.delete(id);
        return modelAndView;
    }
}
