package com.exercise.blog.service;

import com.exercise.blog.model.Blog;
import com.exercise.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageble);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> findByName(String title, Pageable pageble);

    List<Blog> findAllByCategoryContaining(Category category);
}
