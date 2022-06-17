package com.product.repository;

import com.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Nokia E63", 1000.00, "Best sell", "Nokia finland"));
        products.put(2, new Product(2, "Samsung Z Fold", 2000.00, "Foldable phone", "Samsung Thai Nguyen"));
        products.put(3, new Product(3, "Iphone", 1500.00, "Luxury", "Apple china"));
        products.put(4, new Product(4, "Xiaomi", 700.00, "Best price", "Xiaomi china"));
        products.put(5, new Product(5, "Oppo", 400.00, "Cheapest", "Oppo china"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
       products.remove(id);
    }

    @Override
    public int getLastId() {
        int lastId = 0;
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getKey() > lastId){
                lastId = entry.getKey();
            }
        }
        return lastId;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item: products.entrySet()) {
            if (item.getValue().getName().toLowerCase().contains(name.toLowerCase())){
                productList.add(item.getValue());
            }
        }
        return productList;
    }
}
