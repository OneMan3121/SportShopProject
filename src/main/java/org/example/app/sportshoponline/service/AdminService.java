package org.example.app.sportshoponline.service;

import org.example.app.sportshoponline.model.Content;
import org.example.app.sportshoponline.model.Order;
import org.example.app.sportshoponline.model.Product;
import org.example.app.sportshoponline.model.User;

public class AdminService {
    private DbService dbService;

    public AdminService(DbService dbService) {
        this.dbService = dbService;
    }

    public void modifyContent(Content content) {
        dbService.update(content);
    }

    public void addUser(User user) {
        dbService.save(user);
    }

    public void changeOrderStatus(Order order, String newStatus) {
        // Логіка зміни статусу замовлення
        order.setStatus(newStatus);
        dbService.update(order);
    }

    public void editOrder(Order order, Order updatedOrder) {
        // Логіка редагування замовлення
        order.setProducts(updatedOrder.getProducts());
        order.setTotalPrice(updatedOrder.getTotalPrice());
        dbService.update(order);
    }

    public void leaveComment(Product product, String comment) {
        if (product != null) {
            product.addComment(comment);
            dbService.update(product);
        }
    }

    public void addProduct(Product product) {
        // Логіка додавання товару
        dbService.save(product);

    }

    public void hideProduct(Product product) {
        // Логіка приховування товару
        product.setHidden(true);
        dbService.update(product);
    }

    public void deleteProduct(Product product) {
        // Логіка видалення товару
        dbService.delete(Product.class, product.getId());
    }


}