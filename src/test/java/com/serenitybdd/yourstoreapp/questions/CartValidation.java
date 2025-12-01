package com.serenitybdd.yourstoreapp.questions;

import com.serenitybdd.yourstoreapp.ui.HeaderUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Arrays;

public class CartValidation {

    public static Performable hasProducts(String... expectedProducts) {
        return Task.where("{0} verifica que el carrito contenga " + Arrays.toString(expectedProducts),
                Ensure.that(HeaderUI.CART_PRODUCT_NAMES)
                        .textValues()
                        .containsExactlyInAnyOrder(expectedProducts)
        );
    }
}