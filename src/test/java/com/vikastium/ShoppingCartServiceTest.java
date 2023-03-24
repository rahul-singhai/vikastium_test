package com.vikastium;

import com.vikastium.service.ShoppingCartService;
import com.vikastium.model.ShoppingCartItem;
import com.vikastium.service.TaxService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartServiceTest {
    private ShoppingCartService shoppingCartService;

    @Before
    public void setUp() {
        //creates an empty cart
        shoppingCartService = new ShoppingCartService();
    }

    @Test
    public void test_addShoppingItemInEmptyCartAndGet() {
        //given
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem("DOVE_SOAP", 39.99);
        //when
        shoppingCartService.addItem(shoppingCartItem, 5);
        //then
        assertTrue(shoppingCartService.getItemQuantity(shoppingCartItem) == 5);
        assertEquals(shoppingCartService.getCartValue(), String.valueOf(199.95));

    }

    @Test
    public void test_addSameShoppingItemMultipleTimesInEmptyCart() {
        //given
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem("Dove Soaps", 39.99);
        shoppingCartService.addItem(shoppingCartItem, 5);
        //when
        shoppingCartService.addItem(new ShoppingCartItem("Dove Soaps", 39.99), 3);
        //then
        assertTrue(shoppingCartService.getItemQuantity(shoppingCartItem) == 8);
        assertEquals(shoppingCartService.getCartValue(), String.valueOf(319.92));
    }

    @Test
    public void test_addMultipleShoppingItemMultipleTimesInEmptyCart() {
        //given
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem("Dove soap", 39.99);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem("Axe deo", 99.99);
        TaxService taxService = new TaxService();
        taxService.setSaleTaxRate(12.5);
        shoppingCartService.setTaxService(taxService);
        //when
        shoppingCartService.addItem(shoppingCartItem1, 2);
        shoppingCartService.addItem(shoppingCartItem2, 2);
        //then
        assertTrue(shoppingCartService.getItemQuantity(shoppingCartItem1) == 2);
        assertTrue(shoppingCartService.getItemQuantity(shoppingCartItem2) == 2);
        assertEquals(shoppingCartService.getTax(), String.valueOf(34.99));
        assertEquals(shoppingCartService.getTotal(), String.valueOf(314.95));

    }


}
