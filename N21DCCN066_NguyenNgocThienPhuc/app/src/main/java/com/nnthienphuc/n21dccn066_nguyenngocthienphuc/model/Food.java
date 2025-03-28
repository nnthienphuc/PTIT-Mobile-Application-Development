package com.nnthienphuc.n21dccn066_nguyenngocthienphuc.model;

public class Food {
    private String Name;
    private int Image;
    private String Description;

    public Food(String name, int image, String description) {
        Name = name;
        Image = image;
        Description = description;
    }

    public Food() {
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
