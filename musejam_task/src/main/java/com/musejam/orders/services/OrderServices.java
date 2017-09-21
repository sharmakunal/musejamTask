package com.musejam.orders.services;

import com.musejam.orders.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderServices {
    public Boolean saveOrder(Order order);
}
