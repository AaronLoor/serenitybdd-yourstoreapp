package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.CheckoutUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ConfirmOrder implements Task {

    public static ConfirmOrder now() {
        return instrumented(ConfirmOrder.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.BUTTON_CONFIRM_ORDER, isClickable())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                Click.on(CheckoutUI.BUTTON_CONFIRM_ORDER)
        );
    }
}