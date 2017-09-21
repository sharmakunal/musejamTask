package com.musejam.orders.entities;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author Kunal
 * It will save Total Order Description and Cost
 */

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OrderId;
    private String orderdescription;
    private Double ordercost;

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Double getOrdercost() {
        return ordercost;
    }

    public void setOrdercost(Double ordercost) {
        this.ordercost = ordercost;
    }
}
