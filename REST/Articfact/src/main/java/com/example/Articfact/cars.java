package com.example.Articfact;

public class cars {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean isRented;

    // Constructeur
    public cars(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.isRented = false;
    }

    // Getters et Setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}