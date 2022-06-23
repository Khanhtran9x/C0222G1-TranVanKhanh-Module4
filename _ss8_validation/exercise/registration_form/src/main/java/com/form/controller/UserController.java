package com.form.controller;

import com.form.model.User;
import com.form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("view")
    public String showIndex() {
        return "view";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/view";
    }
}
