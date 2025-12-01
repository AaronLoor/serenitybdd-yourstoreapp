package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CommonUI {
    public static final Target SUCCESS_ALERT = Target.the("alerta de éxito al agregar")
            .located(By.cssSelector(".alert-success"));
}