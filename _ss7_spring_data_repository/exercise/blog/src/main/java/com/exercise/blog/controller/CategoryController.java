package com.exercise.blog.controller;

import com.exercise.blog.model.Category;
import com.exercise.blog.service.IBlogService;
import com.exercise.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").descending();
        model.addAttribute("categoryList", categoryService.findAll(PageRequest.of(page, 2, sort)));
        return "category/index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        Optional<Category> category = categoryService.findById(id);
        categoryService.remove(category.get());
        return "redirect:/category";
    }

    @GetMapping("/{id}/blog")
    public String showBlogList(@PathVariable Integer id, Model model){
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category.get());
        return "category/view";
    }
}
