package com.example.demo.controller;

import com.example.demo.service.Mean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeanController {

    @PostMapping("/calculate-mean")
    public double calculateMean(@RequestBody List<String> numbers) {
        return Mean.calculateMean(numbers);
    }
}