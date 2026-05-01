package com.example.dclassicsbooks;

public class Book {
    String title, author, price, summary;
    int imageResId;

    public Book(String title, String author, String price, String summary, int imageResId) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.summary = summary;
        this.imageResId = imageResId;
    }
}
