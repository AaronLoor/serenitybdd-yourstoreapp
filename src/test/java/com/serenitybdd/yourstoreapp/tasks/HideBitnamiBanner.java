package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.CommonUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HideBitnamiBanner implements Task {

    @Override
    @Step("{0} hides the Bitnami banner if present")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript(CommonUI.SCRIPTJS_REMOVE_BITNAMI);
    }

    public static HideBitnamiBanner ifPresent() {
        return instrumented(HideBitnamiBanner.class);
    }
}