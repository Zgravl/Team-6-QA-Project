package com.example.demo.controller;

import com.example.demo.service.RegressionPrediction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegressionPredictionController {

    @PostMapping("/predict-y")
    public String predictYValue(@RequestBody List<String> input) {
        return RegressionPrediction.predictYValue(input);
    }
}