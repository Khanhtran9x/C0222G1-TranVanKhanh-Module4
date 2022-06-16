package com.medical.controller;

import com.medical.model.MedicalDeclaration;
import com.medical.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("dateOfBirth", medicalDeclarationService.getDateOfBirth());
        model.addAttribute("nation", medicalDeclarationService.getNation());
        model.addAttribute("transportation", medicalDeclarationService.getTransportationInformation());
        model.addAttribute("startDay", medicalDeclarationService.getDay());
        model.addAttribute("startMonth", medicalDeclarationService.getMonth());
        model.addAttribute("startYear", medicalDeclarationService.getYear());
        model.addAttribute("endDay", medicalDeclarationService.getDay());
        model.addAttribute("endMonth", medicalDeclarationService.getMonth());
        model.addAttribute("endYear", medicalDeclarationService.getYear());
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "home";
    }

    @PostMapping("/save-medical-declaration")
    public String saveMedicalDeclaration(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration){
        medicalDeclarationService.saveDeclaration(medicalDeclaration);
        return "redirect:/showSubmittedDeclaration";
    }

    @GetMapping("/showSubmittedDeclaration")
    public String showSubmittedDeclaration(Model model){
        model.addAttribute("medicalDeclaration", medicalDeclarationService.getDeclaration());
        return "declaration";
    }
}
