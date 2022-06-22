package com.exercise.blog.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "DATE")
    private String creatingDate;

    @ManyToOne(targetEntity = Category.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String creatingDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creatingDate = creatingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(String creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
