package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.saveBlog(blog.getTitle(), blog.getContent(), blog.getCreatingDate());
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
    public List<Blog> searchByName(String title) {
        return iBlogRepository.searchByName("%" + title + "%");
    }
}
