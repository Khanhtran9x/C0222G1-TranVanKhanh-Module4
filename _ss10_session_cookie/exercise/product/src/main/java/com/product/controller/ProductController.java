package com.product.controller;

import com.product.model.Cart;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    private String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("productList", productService.findAll(PageRequest.of(page, 7, sort)));
        return "/product/shop";
    }

    @GetMapping("/{id}/detail")
    private String showDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id).get());
        return "/product/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/cart";
        }
        cart.addProduct(product.get());
        redirectAttributes.addFlashAttribute("msg", "Product added to cart successfully");
        return "redirect:/product";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseProduct(@PathVariable Integer id, @ModelAttribute Cart cart){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error404";
        }
        cart.decreaseProduct(product.get());
        return "redirect:/cart";
    }
}
