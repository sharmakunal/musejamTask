package com.musejam.orders.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kunal on 19-09-2017.
 *
 */
@Entity(name = "addon")
@DiscriminatorValue("addon")
public  class OrderAddOnItem extends Product{

    transient Product product;

    public OrderAddOnItem(Product product) {
        this.product=product;
    }

    public OrderAddOnItem() {
    }

    public Product getProduct() {
        return product;
    }

    public OrderAddOnItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public String getDescription() {
        if (product!=null)
            return product.getDescription()+", "+this.getName();
        return this.getName();
    }

    @Override
    public Double getCost() {
        if(product!=null)
            return product.getCost()+this.cost;
        return this.cost;
    }
}
