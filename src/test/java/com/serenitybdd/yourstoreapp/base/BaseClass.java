package com.serenitybdd.yourstoreapp.base;

import com.serenitybdd.yourstoreapp.config.ConfigurationManager;
import com.serenitybdd.yourstoreapp.context.TestContext;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public abstract class BaseClass {

    protected final ConfigurationManager config = ConfigurationManager.getInstance();

    protected final TestContext context = TestContext.getInstance();

    protected String getBaseUrl() {
        return config.getBaseUrl();
    }

    protected Actor getOrCreateActor() {
        if (context.hasActor()) {
            return context.getCurrentActor();
        }
        var actor = OnStage.theActorCalled("Usuario");
        context.setCurrentActor(actor);

        return actor;
    }
}