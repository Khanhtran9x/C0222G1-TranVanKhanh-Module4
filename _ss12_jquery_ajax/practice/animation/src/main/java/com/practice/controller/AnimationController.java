package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimationController {
    @GetMapping("")
    public String showIndex(){
        return "index";
    }
}
