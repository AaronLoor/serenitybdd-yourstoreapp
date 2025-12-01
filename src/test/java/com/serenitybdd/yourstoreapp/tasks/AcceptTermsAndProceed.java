package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.CheckoutUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AcceptTermsAndProceed implements Task {

    public static AcceptTermsAndProceed toNextStep() {
        return instrumented(AcceptTermsAndProceed.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.TERMS_CHECKBOX, isClickable())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                Click.on(CheckoutUI.TERMS_CHECKBOX),
                Click.on(CheckoutUI.BUTTON_CONTINUE_PAYMENT)
        );
    }
}