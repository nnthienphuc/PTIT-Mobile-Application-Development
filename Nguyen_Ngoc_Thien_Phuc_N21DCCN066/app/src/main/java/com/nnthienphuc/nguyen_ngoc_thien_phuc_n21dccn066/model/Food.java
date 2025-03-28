package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model;

public class Food {
    private String name;
    private int image;
    private String description;
    private double price;

    public Food(String name, int image, String description, double price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
}
