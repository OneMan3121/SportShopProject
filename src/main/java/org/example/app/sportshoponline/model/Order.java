package org.example.app.sportshoponline.model;

import java.util.List;

public class Order {
    private int id;
    private int userId;
    private String status;
    private List<Product> products;
    private double totalPrice;

    // Конструктор, геттери і сеттери

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        // Розрахунок загальної ціни замовлення на основі цін всіх товарів у замовленні
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}