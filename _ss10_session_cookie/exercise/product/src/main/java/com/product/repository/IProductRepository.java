package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
