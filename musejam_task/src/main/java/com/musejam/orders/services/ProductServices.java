package com.musejam.orders.services;

import com.musejam.orders.entities.Product;

import java.util.List;

public interface ProductServices {
    public void saveProduct(Product product);

    public List<Product> getAllProducts(String productType);

    public Product getProductByName(String name);
}
