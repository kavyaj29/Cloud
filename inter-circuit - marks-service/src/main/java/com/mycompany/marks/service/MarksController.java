/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marks.service;

/**
 *
 * @author Yuvraj
 */
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @GetMapping("/{regNo}")
    public String getMarks(@PathVariable String regNo) {

        return "Science=99, CAO=98, OS=92";
    }
}