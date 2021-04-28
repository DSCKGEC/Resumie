package com.example.resumie.portfolio;

import java.io.Serializable;

public class PortfolioItem implements Serializable {
    private String title,description;
    private int image;

    public PortfolioItem(){
    }

    public PortfolioItem(int image) {
        this.image = image;
    }

    public PortfolioItem(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public PortfolioItem(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
