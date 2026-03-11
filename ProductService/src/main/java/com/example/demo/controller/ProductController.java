package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
}