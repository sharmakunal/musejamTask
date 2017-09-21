package com.musejam.orders.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public abstract class Product {

     @Id
     String name;
     Double cost;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public abstract String getDescription();

    public abstract Double getCost();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
