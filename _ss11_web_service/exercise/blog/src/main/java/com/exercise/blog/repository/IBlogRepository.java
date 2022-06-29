package com.exercise.blog.repository;

import com.exercise.blog.model.Blog;
import com.exercise.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Query(value = "INSERT INTO blog (title, content, creating_date, category_id) VALUES (:title, :content, :creatingDate, :categoryId)", nativeQuery = true)
    void saveBlog(@Param("title") String title,
                  @Param("content") String content,
                  @Param("creatingDate") String creatingDate,
                  @Param("categoryId") Integer categoryId);

    @Query(value = "SELECT * FROM blog", nativeQuery = true)
    Page<Blog> findAll(Pageable pageble);

    @Query(value = "SELECT * FROM blog WHERE id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE blog SET title = :title, content = :content, creating_date = :creatingDate WHERE id = :id", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("content") String content,
                @Param("creatingDate") String creatingDate,
                @Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM blog WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

    @Query(value = "SELECT *  FROM blog WHERE title LIKE :title AND category_id LIKE :categoryId", nativeQuery = true)
    Page<Blog> searchByName(@Param("title") String title, @Param("categoryId") String categoryId, Pageable pageble);

    List<Blog> findAllByCategoryContaining(Category category);
}
