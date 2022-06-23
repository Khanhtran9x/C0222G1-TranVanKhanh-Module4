package com.form.service;

import com.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IUserService {
    Page<User> findAll(Pageable pageble);

    void save(User user);

    Optional<User> findById(Integer id);

    void update(User user);

    void remove(User user);

    Page<User> findAllByName(String name, Pageable pageble);
}
