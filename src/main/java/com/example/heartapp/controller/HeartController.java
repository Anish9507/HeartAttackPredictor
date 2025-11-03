package com.example.heartapp.controller;

import com.example.heartapp.model.RiskCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HeartController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateRisk(@RequestParam Map<String, String> formData, Model model) {
        int score = RiskCalculator.calculate(formData);
        String category = RiskCalculator.getCategory(score);
        String advice = RiskCalculator.getAdvice(category);

        model.addAttribute("score", score);
        model.addAttribute("category", category);
        model.addAttribute("advice", advice);

        return "result";
    }
}
