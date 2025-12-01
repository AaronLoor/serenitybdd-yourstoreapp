package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryUI {

    public static Target addToCartButtonFor(String productName) {

        String xpath = "//h4/a[contains(text(), '" + productName + "')]" +
                "/ancestor::div[contains(@class, 'product-layout')]" +
                "//button[contains(@onclick, 'cart.add')]";

        return Target.the("botón agregar al carrito para " + productName)
                .located(By.xpath(xpath));
    }
}
