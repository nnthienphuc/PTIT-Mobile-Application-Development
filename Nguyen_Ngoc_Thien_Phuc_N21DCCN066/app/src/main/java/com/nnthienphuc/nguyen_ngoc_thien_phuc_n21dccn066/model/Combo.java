package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model;

public class Combo {
    private String name;
    private int image;
    private int time;

    public Combo(String name, int image, int time) {
        this.name = name;
        this.image = image;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getTime() {
        return time;
    }
}
