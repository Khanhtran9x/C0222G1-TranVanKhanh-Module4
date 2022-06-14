package com.convert_currency.controller;

import com.convert_currency.service.Conversion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertCurrencyController {
    private Conversion conversion = new Conversion();

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/home")
    public ModelAndView convert(String usd){
        ModelAndView modelAndView = new ModelAndView("home");
        double vnd = conversion.convertUsdToVnd(Double.parseDouble(usd));
        modelAndView.addObject("vnd", vnd);
        modelAndView.addObject("usd", usd);
        return modelAndView;
    }
}
