package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchUI {

    public static final Target SEARCH_BOX = Target.the("caja de texto buscador")
            .located(By.name("search"));

    public static final Target SEARCH_BUTTON = Target.the("botón lupa buscar")
            .located(By.cssSelector("#search button"));
}