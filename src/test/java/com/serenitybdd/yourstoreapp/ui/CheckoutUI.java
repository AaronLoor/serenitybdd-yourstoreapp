package com.serenitybdd.yourstoreapp.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class CheckoutUI {

    public static final Target GUEST_RADIO_BUTTON = Target.the("radio button Compra como Invitado")
            .located(By.cssSelector("input[type='radio'][value='guest']"));

    public static final Target STEP_1_CONTINUE_BUTTON = Target.the("botón continuar del paso 1")
            .located(By.id("button-account"));

    public static final Target FIRST_NAME_INPUT = Target.the("campo nombre")
            .located(By.id("input-payment-firstname"));

    public static final Target LAST_NAME_INPUT = Target.the("campo apellido")
            .located(By.id("input-payment-lastname"));

    public static final Target EMAIL_INPUT = Target.the("campo email")
            .located(By.id("input-payment-email"));

    public static final Target TELEPHONE_INPUT = Target.the("campo teléfono")
            .located(By.id("input-payment-telephone"));

    public static final Target ADDRESS_INPUT = Target.the("campo dirección 1")
            .located(By.id("input-payment-address-1"));

    public static final Target CITY_INPUT = Target.the("campo ciudad")
            .located(By.id("input-payment-city"));

    public static final Target POST_CODE_INPUT = Target.the("campo código postal")
            .located(By.id("input-payment-postcode"));

    public static final Target COUNTRY_DROPDOWN = Target.the("lista de países")
            .located(By.id("input-payment-country"));

    public static final Target REGION_DROPDOWN = Target.the("lista de regiones/estados")
            .located(By.id("input-payment-zone"));

    public static final Target STEP_2_CONTINUE_BUTTON = Target.the("botón continuar datos personales")
            .located(By.id("button-guest"));

    public static final Target BUTTON_CONTINUE_DELIVERY = Target.the("botón continuar método de envío")
            .located(By.id("button-shipping-method"));

    public static final Target TERMS_CHECKBOX = Target.the("checkbox términos y condiciones")
            .located(By.name("agree"));

    public static final Target BUTTON_CONTINUE_PAYMENT = Target.the("botón continuar método de pago")
            .located(By.id("button-payment-method"));

    public static final Target BUTTON_CONFIRM_ORDER = Target.the("botón confirmar orden final")
            .located(By.id("button-confirm"));
}