package com.example.dclassicsbooks;

public class Book {
    private String title;
    private String author;
    private String price;
    private String synopsis;
    private int coverImage;

    public Book(String title, String author, String price, String synopsis, int coverImage) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.synopsis = synopsis;
        this.coverImage = coverImage;
    }

    public Book(String title, String author, int coverImage, String synopsis) {
        this.title = title;
        this.author = author;
        this.coverImage = coverImage;
        this.price = "";
        this.synopsis = synopsis;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPrice(){ return price; }
    public String getSynopsis(){ return synopsis; }
    public int getCoverImage() { return coverImage; }
}

