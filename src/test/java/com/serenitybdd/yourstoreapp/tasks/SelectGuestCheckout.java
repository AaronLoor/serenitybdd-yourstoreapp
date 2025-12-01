package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.CheckoutUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectGuestCheckout implements Task {

    public static SelectGuestCheckout option() {
        return instrumented(SelectGuestCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.GUEST_RADIO_BUTTON, isClickable())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),

                Click.on(CheckoutUI.GUEST_RADIO_BUTTON),

                WaitUntil.the(CheckoutUI.STEP_1_CONTINUE_BUTTON, isClickable()),
                Click.on(CheckoutUI.STEP_1_CONTINUE_BUTTON)
        );
    }
}