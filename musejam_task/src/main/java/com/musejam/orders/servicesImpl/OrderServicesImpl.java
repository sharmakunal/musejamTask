package com.musejam.orders.servicesImpl;

import com.musejam.orders.daoImpl.OrderDaoImple;
import com.musejam.orders.entities.Order;
import com.musejam.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServicesImpl implements OrderServices{

    @Autowired
    OrderDaoImple ordersDao;

    /*
    *  @param order takes order to save
   *   @return Boolean for the status
   * */

    @Override
    public Boolean saveOrder(Order order) {
        return ordersDao.saveOrder(order);
    }
}
