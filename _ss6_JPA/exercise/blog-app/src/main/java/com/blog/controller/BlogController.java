package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/read")
    public String showRead(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String searchByName(String title, Model model){
        model.addAttribute("blogList", blogService.searchByName(title));
        return "index";
    }
}
