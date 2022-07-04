package com.exercise.blog.service;

import com.exercise.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageble);
    void save(Category category);
    Optional<Category> findById(Integer id);
    void update(Category category);
    void remove(Category category);
}
