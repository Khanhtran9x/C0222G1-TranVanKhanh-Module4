package com.product.service;

import com.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(int id);

    void update(Product product);

    void remove(Product product);

    Page<Product> searchByName(String name, Pageable page);
}
