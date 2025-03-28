package com.nnthienphuc.n21dccn066_nguyenngocthienphuc.model;

public class Food2 {
    private String name;
    private int image;
    private int calories;
    private int protein;
    private int fat;

    public Food2(String name, int image, int calories, int protein, int fat) {
        this.name = name;
        this.image = image;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
    }

    // Getters
    public String getName() { return name; }
    public int getImage() { return image; }
    public int getCalories() { return calories; }
    public int getProtein() { return protein; }
    public int getFat() { return fat; }
}

