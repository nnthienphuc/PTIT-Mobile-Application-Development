package com.nnthienphuc.midtermtest.model;

public class Food {
    private String Name;
    private int Image;
    private String Description;
    private int Quantity = 0;

    public Food(String name, int image, String description) {
        Name = name;
        Image = image;
        Description = description;
    }

    public Food() {
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
