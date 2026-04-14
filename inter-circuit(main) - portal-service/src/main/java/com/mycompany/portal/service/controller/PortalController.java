package com.mycompany.portal.service.controller;

/**
 *
 * @author Yuvraj
 */
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/result-summary")
public class PortalController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Lazy
    private PortalController self;

    @GetMapping("/{regNo}")
    public Map<String, Object> getResult(@PathVariable String regNo) {

        Map<String, Object> response = new HashMap<>();

        response.put("Name", "Amrita Roy");
        response.put("Department", "CSE");
        response.put("Batch", "2023–2027");

        String marks = self.getMarks(regNo);
        String grade = self.getGrade(regNo);

        response.put("Marks", marks);
        response.put("Final Result", grade);

        return response;
    }

    @CircuitBreaker(name = "marksService", fallbackMethod = "marksFallback")
    public String getMarks(String regNo) {
        return restTemplate.getForObject("http://localhost:8081/marks/" + regNo, String.class);
    }

    public String marksFallback(String regNo, Throwable t) {
        return "Marks temporarily unavailable";
    }

    @CircuitBreaker(name = "gradeService", fallbackMethod = "gradeFallback")
    public String getGrade(String regNo) {
        return restTemplate.getForObject("http://localhost:8082/grade/" + regNo, String.class);
    }

    public String gradeFallback(String regNo, Throwable t) {
        return "Grade calculation temporarily unavailable";
    }
}
