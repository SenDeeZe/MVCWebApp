package org.example.controllers;

import org.example.entities.Order;
import org.example.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping({"/hello"})
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView orderPage() {
        List<Order> orders = orderService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderPage");
        modelAndView.addObject("orderList", orders);
        return modelAndView;
    }

    @RequestMapping(value = "/find/", method = RequestMethod.POST)
    public ModelAndView findOrderPage(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.setViewName("findOrderPage");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView orderUpdatePage(@PathVariable("id") Integer id) {
        System.out.println("update1");
        Order order = orderService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderUpdatePage");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateOrder(@ModelAttribute("order") Order order) {
        System.out.println("update2");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.update(order);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addOrderPage() {
        System.out.println("create1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderUpdatePage");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute("order") Order order) {
        System.out.println("create2");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.create(order);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.delete(id);
        return modelAndView;
    }
}
