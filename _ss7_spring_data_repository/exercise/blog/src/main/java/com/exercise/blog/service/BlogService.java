package com.exercise.blog.service;

import com.exercise.blog.model.Blog;
import com.exercise.blog.model.Category;
import com.exercise.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageble) {
        return iBlogRepository.findAll(pageble);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.saveBlog(blog.getTitle(), blog.getContent(), blog.getCreatingDate(), blog.getCategory().getId());
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getTitle(), blog.getContent(), blog.getCreatingDate(), blog.getId());
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.remove(id);
    }

    @Override
    public Page<Blog> searchByName(String title, String categoryId, Pageable pageble) {
        return iBlogRepository.searchByName("%" + title + "%", "%" + categoryId + "%", pageble);
    }

    @Override
    public List<Blog> findAllByCategoryContaining(Category category) {
        return iBlogRepository.findAllByCategoryContaining(category);
    }
}
