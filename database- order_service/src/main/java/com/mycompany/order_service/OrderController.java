/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.order_service;

/**
 *
 * @author Yuvraj
 */
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrderController {

    private final OrderRepo repo;

    public OrderController(OrderRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/orders")
    public OrderEntity add(@RequestBody OrderEntity o) {
        return repo.save(o);
    }

    @GetMapping("/orders")
    public List<OrderEntity> all() {
        return repo.findAll();
    }
}