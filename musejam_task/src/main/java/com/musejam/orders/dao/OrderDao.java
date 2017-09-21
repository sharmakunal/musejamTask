package com.musejam.orders.dao;

import com.musejam.orders.entities.Order;

public interface OrderDao {
    public Boolean saveOrder(Order order);
}
