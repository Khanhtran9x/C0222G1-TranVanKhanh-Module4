package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showIndex(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String update(Product product){
       productService.update(product.getId(), product);
       return "redirect:/";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("product", new Product(productService.getLastId() + 1));
        return "create";
    }

    @PostMapping("save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id,Model model){
         model.addAttribute("product", productService.findById(id));
         return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model){
         model.addAttribute("products", productService.searchByName(name));
         return "index";
    }
}
