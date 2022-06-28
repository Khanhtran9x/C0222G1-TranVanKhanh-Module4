package com.product.controller;

import com.product.model.Cart;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("")
    public String showCart (@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "/cart/cart";
    }

    @GetMapping("/order")
    public String showOrder(){
        return "/cart/order";
    }

    @PostMapping("/payment")
    public String showPayment(){
        return "/cart/payment";
    }

    @GetMapping("/clear")
    public String clearCart(@SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes){
        cart.clearCart();
        redirectAttributes.addFlashAttribute("msg", "Product ordered successfully!!");
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.removeProduct(product.get());
        return "redirect:/cart";
    }
}
