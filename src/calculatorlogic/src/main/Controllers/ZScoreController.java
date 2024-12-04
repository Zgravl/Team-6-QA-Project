package com.example.demo.controller;


import com.example.demo.service.ZScore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ZScoreController {

    @PostMapping("/calculate-zscore")
        public double calculateZscore(@RequestBody List<String> numbers) {
            return ZScore.calculateZScore(numbers);
        }
}