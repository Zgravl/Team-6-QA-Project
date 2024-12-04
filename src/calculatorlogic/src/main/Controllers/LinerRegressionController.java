package com.example.demo.controller;

import com.example.demo.service.LinearRegression;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LinearRegressionController {

    @PostMapping("/calculate-linear-regression")
    public String calculateLinearRegression(@RequestBody List<String> input) {
        return LinearRegression.calculateLinearRegression(input);
    }
}