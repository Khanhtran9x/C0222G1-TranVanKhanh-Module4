package com.calculator.controller;

import com.calculator.service.ICalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculationService calculationService;

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @PostMapping("/calculate")
    public String calculate(Double firstNumber,
                            Double secondNumber,
                            String operator,
                            RedirectAttributes redirectAttributes){
        double result = calculationService.calculate(firstNumber, secondNumber, operator);
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("firstNumber", firstNumber);
        redirectAttributes.addFlashAttribute("secondNumber", secondNumber);
        return "redirect:/";
    }
}
