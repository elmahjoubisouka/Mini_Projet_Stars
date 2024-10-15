package com.example.tp_star.beans;

public class Star {
    private int id;
    private String name;
    private int imageResource;
    private float starRating;

    public Star(String name, int imageResource, float starRating) {
        this.name = name;
        this.imageResource = imageResource;
        this.starRating = starRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }
}
