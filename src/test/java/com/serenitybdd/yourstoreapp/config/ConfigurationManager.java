package com.serenitybdd.yourstoreapp.config;

import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

public class ConfigurationManager {

    private static final ThreadLocal<ConfigurationManager> instance = new ThreadLocal<>();

    private ConfigurationManager() {
        configurePageObjectPlaceholders();
    }

    public static ConfigurationManager getInstance() {
        if (instance.get() == null) {
            instance.set(new ConfigurationManager());
        }
        return instance.get();
    }

    public static void reset() {
        instance.remove();
    }

    private void configurePageObjectPlaceholders() {
        try {
            System.setProperty("swagLabsUrl", getBaseUrl());
        } catch (Exception e) {
            System.err.println("⚠️ Warning: No se pudieron configurar placeholders: " + e.getMessage());
        }
    }

    public String getBaseUrl() {
        return getDefaultAppUrlSerenityProperty();
    }

    private String getDefaultAppUrlSerenityProperty() {
        try {
            var environmentVariables = WebDriverConfiguredEnvironment.getEnvironmentVariables();
            var environmentValueDefault = EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty("environments.default");
            var value = EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty("environments.".concat(environmentValueDefault).concat(".").concat("app.url"));
            return value != null ? value : "";

        } catch (Exception e) {
            var systemValue = System.getProperty("environments.default");
            if (systemValue != null) {
                return systemValue;
            }

            System.err.println("⚠️ Error accessing serenity.conf property '" + "environments.default" + "': " + e.getMessage());
            return "";
        }
    }
}