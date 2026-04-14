/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryservice.controller;

/**
 *
 * @author Yuvraj
 */
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private Map<String, String> libraryData = new HashMap<>();

    public LibraryController() {
        libraryData.put("Book", "How to Kill a Dragon");
        libraryData.put("Author", "J.R.R tolkein");
        libraryData.put("Timing", "9 AM - 9 PM");
        libraryData.put("Location", "VIT Library");
    }

    // GET
    @GetMapping
    public Map<String, String> getLibraryInfo() {
        return libraryData;
    }

    // POST
    @PostMapping
    public String addLibraryInfo(@RequestParam String key,
                                 @RequestParam String value) {
        libraryData.put(key, value);
        return "Library information added";
    }

    // PUT
    @PutMapping
    public String updateLibraryInfo(@RequestParam String key,
                                    @RequestParam String value) {
        libraryData.put(key, value);
        return "Library information updated";
    }

    // DELETE
    @DeleteMapping
    public String deleteLibraryInfo(@RequestParam String key) {
        libraryData.remove(key);
        return "Library information deleted";
    }
}
