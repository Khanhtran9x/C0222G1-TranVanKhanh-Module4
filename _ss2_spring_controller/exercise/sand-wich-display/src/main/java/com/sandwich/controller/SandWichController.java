package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandWichController {

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiments") String[] condiments, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("condiments", condiments);
        return "redirect:/";
    }
}
