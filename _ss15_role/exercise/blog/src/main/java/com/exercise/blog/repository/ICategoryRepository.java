package com.exercise.blog.repository;

import com.exercise.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
