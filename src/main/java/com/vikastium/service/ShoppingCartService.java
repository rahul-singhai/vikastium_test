package com.vikastium.service;

import com.vikastium.model.ShoppingCartItem;
import com.vikastium.util.FormatUtil;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {
    private Map<ShoppingCartItem, Integer> shoppingCart;
    private TaxService taxService;


    public ShoppingCartService() {
        shoppingCart = new HashMap<>();
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public void addItem(ShoppingCartItem shoppingCartItem, int quantity) {
        if (shoppingCart.containsKey(shoppingCartItem)) {
            shoppingCart.put(shoppingCartItem, shoppingCart.get(shoppingCartItem) + quantity);
        } else {
            shoppingCart.put(shoppingCartItem, quantity);
        }
    }

    private double getShoppingCartTotalValue() {
        double cartValue = 0.0;
        for (ShoppingCartItem shoppingCartItem : shoppingCart.keySet()) {
            cartValue += shoppingCartItem.getPrice() * shoppingCart.get(shoppingCartItem);
        }
        return cartValue;
    }

    private double getTotalTax() {
        return Double.valueOf(taxService.getTax(this.getShoppingCartTotalValue()));
    }

    public Integer getItemQuantity(ShoppingCartItem shoppingCartItem) {
        return shoppingCart.get(shoppingCartItem);
    }

    public String getCartValue() {
        return FormatUtil.format(this.getShoppingCartTotalValue());
    }

    public String getTax() {
        return taxService.getTax(this.getShoppingCartTotalValue());
    }

    public String getTotal() {
        return FormatUtil.format(this.getShoppingCartTotalValue() + this.getTotalTax());
    }


}
