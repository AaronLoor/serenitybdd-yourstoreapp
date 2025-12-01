package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.HeaderUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewShoppingCart implements Task {

    public static ViewShoppingCart click() {
        return instrumented(ViewShoppingCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HeaderUI.SHOPPING_CART_BUTTON, isVisible())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                Click.on(HeaderUI.SHOPPING_CART_BUTTON)
        );
    }
}