package com.example.resumie.team;

public class TeamItem {
    private String author_name;
    private String author_description;
    private int author_icon;

    public TeamItem(String author_name, String author_description, int author_icon) {
        this.author_name = author_name;
        this.author_description = author_description;
        this.author_icon = author_icon;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_description() {
        return author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
    }

    public int getAuthor_icon() {
        return author_icon;
    }

    public void setAuthor_icon(int author_icon) {
        this.author_icon = author_icon;
    }
}
