package com.email.controller;

import com.email.model.EmailConfiguration;
import com.email.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailConfigurationController {

    @Autowired
    private IEmailConfigurationService emailConfigurationService;

    @GetMapping("/")
    public String showHomePage(Model model){
        String[] languages = emailConfigurationService.getLanguages();
        Integer[] pageSizes = emailConfigurationService.getPageSizes();
        model.addAttribute("emailConfiguration", new EmailConfiguration());
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        return "home";
    }

    @PostMapping("/saveConfiguration")
    public String saveEmailConfiguration(@ModelAttribute("emailConfiguration")  EmailConfiguration emailConfiguration){
        emailConfigurationService.saveConfig(emailConfiguration);
        return "email-configuration";
    }

    @GetMapping("/email-configuration")
    public String showEmailConfiguration(Model model){
        EmailConfiguration emailConfiguration = emailConfigurationService.getConfig();
        model.addAttribute("emailConfiguration", emailConfiguration);
        return "/email-configuration";
    }
}
