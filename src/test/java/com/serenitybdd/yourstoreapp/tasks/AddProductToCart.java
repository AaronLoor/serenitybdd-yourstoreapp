package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.config.AppConstants;
import com.serenitybdd.yourstoreapp.ui.CommonUI;
import com.serenitybdd.yourstoreapp.ui.InventoryUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    public static AddProductToCart named(String productName) {
        return instrumented(AddProductToCart.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target targetButton = InventoryUI.addToCartButtonFor(productName);

        actor.attemptsTo(
                WaitUntil.the(targetButton, isVisible()).forNoMoreThan(AppConstants.Timeouts.SHORT).seconds(),
                HideBitnamiBanner.ifPresent(),
                Scroll.to(targetButton),
                Click.on(targetButton),

                WaitUntil.the(CommonUI.SUCCESS_ALERT, isVisible())
                        .forNoMoreThan(AppConstants.Timeouts.SHORT).seconds()
        );
    }
}