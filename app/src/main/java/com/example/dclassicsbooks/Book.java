package com.example.dclassicsbooks;

public class Book {
    String title, author, price;
    int imageResId;

    public Book(String title, String author, String price, int imageResId) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageResId = imageResId;
    }
}