package com.example.demo.controller;

import com.example.demo.service.PopulationStandardDeviation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PSDController {

    @PostMapping("/calculate-population-std-dev")
    public double calculatePopulationStandardDeviationStandardDeviation(@RequestBody List<String> numbers) {
        return PopulationStandardDeviation.calculatePopulationStandardDeviation(numbers);
    }
}