package com.example.demo.controller;

import com.example.demo.service.SampleStandardDeviation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SSDController {

    @PostMapping("/calculate-sample-std-dev")
    public double calculateSampleStandardDeviation(@RequestBody List<String> numbers) {
        return SampleStandardDeviation.calculateSampleStandardDeviation(numbers);
    }
}