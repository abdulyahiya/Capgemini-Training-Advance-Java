package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}
