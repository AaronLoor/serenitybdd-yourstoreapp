package com.serenitybdd.yourstoreapp.tasks;

import com.serenitybdd.yourstoreapp.config.ConfigurationManager;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {

    private final String targetUrl;
    private static final ConfigurationManager config = ConfigurationManager.getInstance();

    public NavigateTo(String url) {
        this.targetUrl = url;
    }

    @Override
    @Step("{0} navega a la URL: {1}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(targetUrl));
    }

    @Step("{0} abre la página principal de la Aplicación")
    public static NavigateTo theHomePage() {
        return instrumented(NavigateTo.class, config.getBaseUrl());
    }
}