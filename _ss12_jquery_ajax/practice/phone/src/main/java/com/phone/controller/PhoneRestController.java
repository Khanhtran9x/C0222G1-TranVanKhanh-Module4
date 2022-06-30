package com.phone.controller;

import com.phone.model.Phone;
import com.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/phones")
public class PhoneRestController {
    @Autowired
    private IPhoneService phoneService;

    @PostMapping
    public ResponseEntity<?> createPhone(@RequestBody Phone phone) {
        phoneService.save(phone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> allPhones(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("id").descending();
        Page<Phone> phones = phoneService.findAll(PageRequest.of(page, 5, sort));
        if (phones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPhoneById(@PathVariable Integer id){
        Optional<Phone> phone = phoneService.findById(id);
        if (!phone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phone.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> editPhone(@PathVariable Integer id, @RequestBody Phone phone) {
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phone.setId(phoneOptional.get().getId());
        phoneService.save(phone);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable Integer id) {
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(phoneOptional.get());
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
