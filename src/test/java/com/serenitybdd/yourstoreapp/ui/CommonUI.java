package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CommonUI {
    public static final Target SUCCESS_ALERT = Target.the("alerta de éxito al agregar")
            .located(By.cssSelector(".alert-success"));
    public static final String SCRIPTJS_REMOVE_BITNAMI = "var banner = document.getElementById('bitnami-banner'); " +
            "if (banner) { " +
            "    banner.parentNode.removeChild(banner); " +
            "} " +
            "var cornerDiv = document.querySelector('.bitnami-corner-image-div'); " +
            "if (cornerDiv) { " +
            "    cornerDiv.parentNode.removeChild(cornerDiv); " +
            "}";
}