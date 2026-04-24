package com.example.dclassicsbooks;

public class Book {
    private String title;
    private String author;
    private int coverImage;

    public Book(String title, String author, int coverImage) {
        this.title = title;
        this.author = author;
        this.coverImage = coverImage;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCoverImage() { return coverImage; }
}

