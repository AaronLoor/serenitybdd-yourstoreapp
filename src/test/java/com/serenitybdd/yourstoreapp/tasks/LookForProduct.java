package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.ui.SearchUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LookForProduct implements Task {

    private final String term;

    public LookForProduct(String term) {
        this.term = term;
    }

    public static LookForProduct withName(String term) {
        return instrumented(LookForProduct.class, term);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SearchUI.SEARCH_BOX, isVisible()),
                Enter.theValue(term).into(SearchUI.SEARCH_BOX),
                Click.on(SearchUI.SEARCH_BUTTON)
        );
    }
}