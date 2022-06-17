package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import com.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    private IDictionaryService dictionary = new DictionaryService();

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/home")
    public ModelAndView dictionaryLookUp(String englishWord){
        ModelAndView modelAndView = new ModelAndView("home");
        String vietnameseWord = dictionary.dictionaryLookup(englishWord);
        modelAndView.addObject("vietnameseWord", vietnameseWord);
        modelAndView.addObject("englishWord", englishWord);
        return  modelAndView;
    }
}
