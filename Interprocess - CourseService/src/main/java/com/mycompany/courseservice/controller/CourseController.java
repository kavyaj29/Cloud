/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Yuvraj
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getCourse(@PathVariable String id) {
        String fee = restTemplate.getForObject(
            "http://localhost:8082/fee/" + id,
            String.class);
        return "Course: AWS and Cloud, " + fee;
    }
}
