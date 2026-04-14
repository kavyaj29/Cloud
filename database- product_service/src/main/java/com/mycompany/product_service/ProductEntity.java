/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.product_service;

/**
 *
 * @author Yuvraj
 */
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_ENTITY")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public double price;

    // getters & setters
}