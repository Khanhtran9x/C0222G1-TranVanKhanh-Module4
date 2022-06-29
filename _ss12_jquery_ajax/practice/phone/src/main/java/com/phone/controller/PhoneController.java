package com.phone.controller;

import com.phone.model.Phone;
import com.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;

    @GetMapping
    public ResponseEntity<?> showAll(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("creating_date").descending();
        Page<Phone> phones = phoneService.findAll(PageRequest.of(page, 2, sort));
        if (phones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("phone", new Phone());
        return "/create";
    }

    @PostMapping
    public ResponseEntity<?> createSmartphone(@RequestBody Phone phone) {
        phoneService.save(phone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }
}
