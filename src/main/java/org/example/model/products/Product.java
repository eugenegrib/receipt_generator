package org.example.model.products;




public class Product {
    private int quantity;
    private int id;
    private String description;
    private double price;
    private boolean promotional;

    public double getTotalWithPromotional() {
        return totalWithPromotional;
    }

    public void setTotalWithPromotional(double totalWithPromotional) {
        this.totalWithPromotional = totalWithPromotional;
    }

    private double totalWithPromotional;
    private double totalWithoutPromotional;

    public double getTotalWithoutPromotional() {
        return totalWithoutPromotional;
    }

    public void setTotalWithoutPromotional(double totalWithoutPromotional) {
        this.totalWithoutPromotional = totalWithoutPromotional;
    }

    public boolean getPromotional() {
        return promotional;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public Product(int id, String description, double price, boolean promotional) {
        super();
        this.id = id;
        this.description = description;
        this.price = price;
        this.promotional = promotional;
    }
}
