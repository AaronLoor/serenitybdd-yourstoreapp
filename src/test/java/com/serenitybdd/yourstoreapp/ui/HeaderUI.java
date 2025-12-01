package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class HeaderUI {

    public static final Target SHOPPING_CART_BUTTON = Target.the("botón para desplegar carrito de compras")
            .located(By.cssSelector("#cart button"));

    public static final Target CART_PRODUCT_NAMES = Target.the("lista de nombres en el carrito")
            .located(By.cssSelector("#cart .table-striped tr td.text-left a"));

    public static final Target CHECKOUT_LINK = Target.the("enlace ir a pagar (Checkout)")
            .located(By.cssSelector("#cart a[href*='checkout/checkout']"));
}