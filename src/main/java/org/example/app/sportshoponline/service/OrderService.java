package org.example.app.sportshoponline.service;

import org.example.app.sportshoponline.model.Order;
import org.example.app.sportshoponline.model.Product;

import java.util.List;

public class OrderService {
    private DbService dbService;

    public OrderService(DbService dbService) {
        this.dbService = dbService;
    }

    public void placeOrder(Order order) {
        List<Product> products = order.getProducts();
        double totalPrice = calculateTotalPriceFromProducts(products);
        order.setTotalPrice(totalPrice);
        dbService.save(order);
    }

    private double calculateTotalPriceFromProducts(List<Product> products) {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void cancelOrder(int orderId) {
        dbService.delete(Order.class, orderId);
    }

    public List<org.springframework.core.annotation.Order> getUserOrders(int userId) {
        return dbService.getUserOrders(userId);
    }
}