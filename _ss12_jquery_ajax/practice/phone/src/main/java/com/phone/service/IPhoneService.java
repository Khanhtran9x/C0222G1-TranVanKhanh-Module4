package com.phone.service;

import com.phone.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPhoneService {
    Page<Phone> findAll(Pageable pageable);
    Optional<Phone> findById(Integer id);
    void save(Phone phone);
    void remove(Phone phone);
}
