package com.mycompany.studentservice.controller;

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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id) {
        String course = restTemplate.getForObject(
            "http://localhost:8081/course/" + id,
            String.class);
        return "Student ID: SWE00" + id + ", " + course;
    }
}
