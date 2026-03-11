package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.feign.ProductClient;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public Order createOrder(Order order) {

        // Call ProductService using Feign
        Product product = productClient.getProductById(order.getProductId());

        if(product != null) {
            order.setProductName(product.getName());
            order.setPrice(product.getPrice());
        }

        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {

        Order existing = orderRepository.findById(id).orElse(null);

        if(existing != null) {
            existing.setProductName(order.getProductName());
            existing.setQuantity(order.getQuantity());
            existing.setPrice(order.getPrice());
            existing.setStatus(order.getStatus());

            return orderRepository.save(existing);
        }

        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}