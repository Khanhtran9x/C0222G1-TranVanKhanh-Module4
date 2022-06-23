package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "(\\w|\\s){2,800}", message = "Wrong product name format")
    private String name;
    @Pattern(regexp = "^\\d*\\.\\d+$", message = "Wrong product price format")
    private String price;
    @Pattern(regexp = "(\\w|\\s){2,800}", message = "Wrong product description format")
    private String description;
    @Pattern(regexp = "(\\w|\\s){2,800}", message = "Wrong product producer format")
    private String producer;

    public Product() {
    }

    public Product(Integer id, String name, String price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
