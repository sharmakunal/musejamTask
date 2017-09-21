package com.musejam.orders.servicesImpl;

import com.musejam.orders.daoImpl.ProductDaoImpl;
import com.musejam.orders.entities.Product;
import com.musejam.orders.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices{

    @Autowired
    ProductDaoImpl productsDao;

     /*
     * @param product takes Product to save
     * @return void
     * */

    @Override
    public void saveProduct(Product product) {
        productsDao.saveProduct(product);
    }

    /**
     * @param productType takes productType to get
     * @return List of Products According to productType
     */

    @Override
    public List<Product> getAllProducts(String productType) {
       return productsDao.getAllProducts(productType);
    }

    /**
     * @param name takes name to get particular product
     * @return Product  according to given product name
     */
    @Override
    public Product getProductByName(String name){
        return productsDao.getProductByName(name);
    }
}
