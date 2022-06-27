package com.library.controller;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("code").descending();
        model.addAttribute("bookList", bookService.findAll(PageRequest.of(page, 4, sort)));
        return "book/list";
    }

    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Book book = bookService.findById(id).get();
        if (book.getNumbers() == 0){
            return handleException();
        } else {
            int code = (int) (Math.random() * 100000) + 1;
            User user = new User(Integer.toString(code), book);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/user/create";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "book/error";
    }
}
