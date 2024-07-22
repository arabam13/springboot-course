package com.course.api.models;

public class Order {
    private String customerName;
    private String productName;
    private int quantity;

    @Override
    public String toString() {
        return "Customer Name: " + customerName + ", Product Name: " + productName + ", Quantity: " + quantity;
    }
}
