package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.HeaderUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ProceedToCheckout implements Task {

    public static ProceedToCheckout start() {
        return instrumented(ProceedToCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HeaderUI.CHECKOUT_LINK, isVisible())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                Click.on(HeaderUI.CHECKOUT_LINK)
        );
    }
}