package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class ConfirmationUI {

    public static final Target SUCCESS_TITLE = Target.the("título de éxito de la orden")
            .located(By.cssSelector("#content h1"));
}