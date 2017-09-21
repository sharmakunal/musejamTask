package com.musejam.orders.dao;

import com.musejam.orders.entities.Product;

import java.util.List;

public interface ProductsDao {

    public Boolean saveProduct(Product product);

    public List<Product> getAllProducts(String productType);

    public Product getProductByName(String name);
}
