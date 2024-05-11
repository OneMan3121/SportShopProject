package org.example.app.sportshoponline.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isDiscount;
    private boolean hidden;

    private List<String> comments;

    // конструктор, геттери і сеттери

    public double getPrice() {
        return price;
    }

    // конструктор, геттери і сеттери для інших властивостей

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public int getId() {
        return id;
    }

    public void addComment(String comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

}
