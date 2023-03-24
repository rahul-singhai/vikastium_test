package com.vikastium.model;

public class ShoppingCartItem {
    private String itemName;
    private double price;

    public ShoppingCartItem(String itemName,double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return itemName.equalsIgnoreCase(that.itemName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return itemName.toLowerCase().hashCode();
    }
}
