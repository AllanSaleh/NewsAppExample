package com.example.allan.newsappexample;

public class NewsArticle {
    private String author;
    private String title;
    private String image;

    public NewsArticle(String author, String title, String image) {
        this.author = author;
        this.title = title;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
