package com.musejam.orders.daoImpl;

import com.musejam.orders.dao.OrderDao;
import com.musejam.orders.entities.Order;
import com.musejam.orders.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImple implements OrderDao{

  /*
   *   @param order takes order to save
     * @return Boolean for the status
     * */
    @Override
    public Boolean saveOrder(Order order) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
