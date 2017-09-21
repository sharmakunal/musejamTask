package com.musejam.orders.daoImpl;

import com.musejam.orders.dao.ProductsDao;
import com.musejam.orders.entities.OrderAddOnItem;
import com.musejam.orders.entities.OrderItem;
import com.musejam.orders.entities.Product;
import com.musejam.orders.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductsDao {

    /**
     * @param product takes Product to save
     * @return Boolean for the status
     */

    @Override
    public Boolean saveProduct(Product product) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(product);

            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param productType takes productType to get
     * @return List of Products According to productType
     */

    @Override
    public List<Product> getAllProducts(String productType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query;
        if (productType.equals("main")) {
            String sql = "SELECT m FROM main m";
            query = session.createQuery(sql, OrderItem.class);
        } else {
            String sql = "SELECT a FROM addon a";
            query = session.createQuery(sql, OrderAddOnItem.class);
        }

        List<Product> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    /**
     * @param name takes name to get particular product
     * @return Product  according to given product name
     */

    public Product getProductByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, name);
        return product;
    }
}
