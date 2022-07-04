package com.exercise.blog.service;

import com.exercise.blog.model.Blog;
import com.exercise.blog.model.Category;
import com.exercise.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageble) {
        return iCategoryRepository.findAll(pageble);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        iCategoryRepository.delete(category);
    }
}
