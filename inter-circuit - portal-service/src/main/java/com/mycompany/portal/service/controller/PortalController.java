package com.mycompany.portal.service.controller;

/**
 *
 * @author Yuvraj
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/result-summary")
public class PortalController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{regNo}")
    public Map<String, Object> getResult(@PathVariable String regNo) {

        Map<String, Object> response = new HashMap<>();

        response.put("Name", "Amrita Roy");
        response.put("Department", "CSE");
        response.put("Batch", "2023–2027");

        String marks;
        try {
            marks = restTemplate.getForObject(
                    "http://localhost:8081/marks/" + regNo,
                    String.class);
        } catch (Exception e) {
            marks = "Marks temporarily unavailable";
        }

        String grade;
        try {
            grade = restTemplate.getForObject(
                    "http://localhost:8082/grade/" + regNo,
                    String.class);
        } catch (Exception e) {
            grade = "Grade calculation temporarily unavailable";
        }

        response.put("Marks", marks);
        response.put("Final Result", grade);

        return response;
    }
}
