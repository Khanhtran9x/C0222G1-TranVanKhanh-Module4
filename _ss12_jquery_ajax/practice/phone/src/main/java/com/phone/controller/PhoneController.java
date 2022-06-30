package com.phone.controller;

import com.phone.model.Phone;
import com.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;

    @GetMapping("")
    public String showAll(@RequestParam(name = "page", defaultValue = "0") int page,Model model) {
        Sort sort = Sort.by("id").descending();
        model.addAttribute("phones", phoneService.findAll(PageRequest.of(page, 5, sort)));
        return "/list";
    }
}
