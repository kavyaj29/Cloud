/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grade.service;

/**
 *
 * @author Yuvraj
 */
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @GetMapping("/{regNo}")
    public String getGrade(@PathVariable String regNo) {

        return "CGPA=9.65, Grade=S";
    }
}