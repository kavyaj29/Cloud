/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customer_service;

/**
 *
 * @author Yuvraj
 */
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepo repo;

    public CustomerController(CustomerRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/customers")
    public Customer add(@RequestBody Customer c) {
        return repo.save(c);
    }

    @GetMapping("/customers")
    public List<Customer> all() {
        return repo.findAll();
    }
}
