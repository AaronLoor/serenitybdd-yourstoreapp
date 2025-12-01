package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.CheckoutUI;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillBillingDetails implements Task {

    public static FillBillingDetails withDefaultData() {
        return instrumented(FillBillingDetails.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.FIRST_NAME_INPUT, isVisible())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),

                Enter.theValue(AppConstants.CustomerData.FIRST_NAME).into(CheckoutUI.FIRST_NAME_INPUT),
                Enter.theValue(AppConstants.CustomerData.LAST_NAME).into(CheckoutUI.LAST_NAME_INPUT),
                Enter.theValue(AppConstants.CustomerData.EMAIL).into(CheckoutUI.EMAIL_INPUT),
                Enter.theValue(AppConstants.CustomerData.PHONE).into(CheckoutUI.TELEPHONE_INPUT),

                Enter.theValue(AppConstants.CustomerData.ADDRESS).into(CheckoutUI.ADDRESS_INPUT),
                Enter.theValue(AppConstants.CustomerData.CITY).into(CheckoutUI.CITY_INPUT),
                Enter.theValue(AppConstants.CustomerData.POST_CODE).into(CheckoutUI.POST_CODE_INPUT),

                SelectFromOptions.byVisibleText(AppConstants.CustomerData.COUNTRY)
                        .from(CheckoutUI.COUNTRY_DROPDOWN),

                WaitUntil.the(CheckoutUI.REGION_DROPDOWN, isEnabled())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),

                SelectFromOptions.byVisibleText(AppConstants.CustomerData.REGION)
                        .from(CheckoutUI.REGION_DROPDOWN),

                Click.on(CheckoutUI.STEP_2_CONTINUE_BUTTON)
        );
    }
}