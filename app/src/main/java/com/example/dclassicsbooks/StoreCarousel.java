package com.example.dclassicsbooks;

public class StoreCarousel {
    private int imageRes;
    private String name;
    private String address;
    private String phone;

    public StoreCarousel(int imageRes, String name, String address, String phone) {
        this.imageRes = imageRes;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter
    public int getImageRes() { return imageRes; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}

