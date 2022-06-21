package com.product.repository;

import com.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public List<Product> findAll() {
        String selectAll = "SELECT p FROM product p";
        List<Product> products = BaseRepository.entityManager.createQuery(selectAll, Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        String select = "SELECT p FROM product p WHERE p.id = ?1";
        Product product = BaseRepository.entityManager.createQuery(select, Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        String search = "SELECT p FROM product p WHERE p.name LIKE ?1";
        return BaseRepository.entityManager.createQuery(search, Product.class).setParameter(1, "%" + name + "%").getResultList();
    }
}
