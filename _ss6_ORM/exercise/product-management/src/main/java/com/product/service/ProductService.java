package com.product.service;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
