package com.exercise.blog.controller;

import com.exercise.blog.model.Blog;
import com.exercise.blog.service.IBlogService;
import com.exercise.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("creating_date").descending();
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogList", blogService.findAll(PageRequest.of(page, 5, sort)));
        return "blog/index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/read")
    public String showRead(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page, String title, String categoryId, Model model){
        Sort sort = Sort.by("creating_date").descending();
        model.addAttribute("blogList", blogService.searchByName(title, categoryId, PageRequest.of(page, 2, sort)));
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/index";
    }
}
