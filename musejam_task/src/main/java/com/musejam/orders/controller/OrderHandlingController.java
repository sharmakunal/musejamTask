package com.musejam.orders.controller;

import com.musejam.orders.entities.Order;
import com.musejam.orders.entities.OrderAddOnItem;
import com.musejam.orders.entities.OrderItem;
import com.musejam.orders.entities.Product;
import com.musejam.orders.services.OrderServices;
import com.musejam.orders.servicesImpl.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Kunal
 * @version 1.0
 *          Handles creates orders
 */

@Controller
public class OrderHandlingController {

    @Autowired
    ProductServicesImpl productServices;

    @Autowired
    OrderServices orderServices;

    static Double cost = 0.0;
    static String allItems = "";

    public Boolean databaseCreation() {
        try {
            Product beer = new OrderItem().setName("Beer").setCost(300.60);
            Product vodka = new OrderItem().setName("Vodka").setCost(500.50);
            Product ice = new OrderAddOnItem().setName("Ice").setCost(30.20);
            Product lime = new OrderAddOnItem().setName("Lime").setCost(40.20);
            Product sprite = new OrderAddOnItem().setName("Sprite").setCost(100.20);

            productServices.saveProduct(beer);
            productServices.saveProduct(vodka);
            productServices.saveProduct(ice);
            productServices.saveProduct(lime);
            productServices.saveProduct(sprite);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }


    @RequestMapping("/")
    ModelAndView index() {
        databaseCreation();
        return fillData();
    }

    public ModelAndView fillData() {
        List<Product> mainProducts = productServices.getAllProducts("main");
        List<Product> addonProducts = productServices.getAllProducts("addon");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mainProducts", mainProducts);
        modelAndView.addObject("addOnProducts", addonProducts);
        return modelAndView;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView handlerOrder(@RequestParam(value = "drink", required = false) String mainDrinks, @RequestParam(value = "addons", required = false) String addons[]) {
        ModelAndView modelAndView = fillData();
        Product product = null;
        if (mainDrinks != null) {
            product = productServices.getProductByName(mainDrinks);
        }
        OrderAddOnItem orderAddOnItem;
        if (addons != null) {

            for (int i = 0; i < addons.length; i++) {
                orderAddOnItem = (OrderAddOnItem) productServices.getProductByName(addons[i]);
                if (product != null) {
                    product = orderAddOnItem.setProduct(product);
                } else {
                    product = orderAddOnItem;
                }

            }
        }
        System.out.println(product.getDescription() + " Rs." + product.getCost());
        cost = cost + product.getCost();
        allItems = allItems + "<tr><td>" + product.getDescription() + "</td><td>Rs." + product.getCost() + "</td></tr>";
            modelAndView.addObject("product", allItems);
            modelAndView.addObject("totalCost", "<td>Total : </td><td>" + cost + "</td>");
            return modelAndView;
    }
}

