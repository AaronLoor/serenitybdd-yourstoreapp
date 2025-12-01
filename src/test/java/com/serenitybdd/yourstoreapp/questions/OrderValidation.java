package com.serenitybdd.yourstoreapp.questions;

import com.serenitybdd.yourstoreapp.config.AppConstants;
import com.serenitybdd.yourstoreapp.ui.ConfirmationUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OrderValidation {

    public static Performable isSuccessful(String expectedMessage) {

        return Task.where("{0} verifica que la orden fue exitosa con el mensaje '" + expectedMessage + "'",
                WaitUntil.the(ConfirmationUI.SUCCESS_TITLE, isVisible())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                Ensure.that(ConfirmationUI.SUCCESS_TITLE)
                        .text()
                        .isEqualTo(expectedMessage)
        );
    }
}