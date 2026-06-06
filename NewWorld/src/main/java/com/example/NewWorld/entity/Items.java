package com.example.NewWorld.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ItemId;
    @NotBlank
    private String Itemname;
    @NotBlank
    private String description;
    @Positive
    private double price;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;
    @NotBlank
    private String sellerName;

    public Items(){};

    public Items(String name, String description, double price, Category category, String sellerName) {
        this.Itemname = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sellerName=sellerName;
    }

    public int getItemId() {
        return ItemId;
    }

//    public void setItemId(int itemId) {
//        ItemId = itemId;
//    }

    public String getName() {
        return Itemname;
    }

    public void setName(String name) {
        this.Itemname = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
