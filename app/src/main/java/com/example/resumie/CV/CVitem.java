package com.example.resumie.CV;

public class CVitem {
    private String title;
    private String description;

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

    public CVitem(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
