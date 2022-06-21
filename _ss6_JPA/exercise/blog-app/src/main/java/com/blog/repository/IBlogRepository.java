package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Query(value = "INSERT INTO blog (title, content, creatingDate) VALUES (:title, :content, :creatingDate)", nativeQuery = true)
    void saveBlog(@Param("title") String title,
                  @Param("content") String content,
                  @Param("creatingDate") String creatingDate);

    @Query(value = "SELECT * FROM blog", nativeQuery = true)
    List<Blog> findAll();

    @Query(value = "SELECT * FROM blog WHERE id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE blog SET title = :title, content = :content, creatingDate = :creatingDate WHERE id = :id", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("content") String content,
                @Param("creatingDate") String creatingDate,
                @Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM blog WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

    @Query(value = "SELECT * FROM blog WHERE title LIKE :title", nativeQuery = true)
    List<Blog> searchByName(@Param("title") String title);
}
