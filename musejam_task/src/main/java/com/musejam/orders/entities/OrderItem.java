package com.musejam.orders.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name = "main")
@DiscriminatorValue("main")
public class OrderItem extends Product {

    @Override
    public String getDescription() {
        return this.getName()+" ";
    }

    @Override
    public Double getCost() {
        return this.cost;
    }

}
