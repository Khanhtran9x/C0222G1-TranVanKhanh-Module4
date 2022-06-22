package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("products", productService.findAll(PageRequest.of(page, 2, sort)));
        return "index";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id).get());
        return "view";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        productService.remove(product.get());
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page, String name, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("products", productService.searchByName(name, PageRequest.of(page, 2, sort)));
        return "index";
    }
}
