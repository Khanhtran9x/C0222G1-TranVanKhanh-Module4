package com.library.controller;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.IBookService;
import com.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").descending();
        model.addAttribute("userList", userService.findAll(PageRequest.of(page, 4, sort)));
        return "user/list";
    }

    @GetMapping("/show-return")
    public String showReturn() {
        return "user/return";
    }

    @GetMapping("/create")
    public String showCreationForm() {
        return "user/create";
    }

    @PostMapping("/save")
    public String save(User user, RedirectAttributes redirectAttributes){
        Book book = user.getBook();
        book.setNumbers(book.getNumbers() - 1);
        bookService.save(book);
        userService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Book borrowed successfully");
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String returnBook(String code, RedirectAttributes redirectAttributes){
        User user = userService.findByCode(code);
        if (user != null){
            Book book = user.getBook();
            book.setNumbers(book.getNumbers() + 1);
            bookService.save(book);
            userService.remove(user);
            redirectAttributes.addFlashAttribute("msg", "Book returned successfully");
            return "redirect:/book";
        } else {
            return handleException();
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "user/error";
    }
}
