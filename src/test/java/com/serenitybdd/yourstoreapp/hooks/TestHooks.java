package com.serenitybdd.yourstoreapp.hooks;

import com.serenitybdd.yourstoreapp.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class TestHooks {

    @Before
    public void setUp(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        TestContext.reset();
    }

    @After
    public void tearDown(Scenario scenario) {
        TestContext testContext = TestContext.getInstance();
        if (testContext != null) {
            testContext.clear();
        }
        OnStage.drawTheCurtain();
    }
}
