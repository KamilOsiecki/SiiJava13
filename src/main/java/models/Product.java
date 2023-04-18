package models;

public class Product {

    private String name;
    private float price;
    private int quantity;
    private float totalPrice;

    public Product(String name, float price, int quantity, float totalPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    //settery dodaj

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}