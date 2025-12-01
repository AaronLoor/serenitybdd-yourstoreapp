package com.serenitybdd.yourstoreapp.stepdefinitions;

import com.serenitybdd.yourstoreapp.base.BaseClass;
import com.serenitybdd.yourstoreapp.config.AppConstants;
import com.serenitybdd.yourstoreapp.questions.CartValidation;
import com.serenitybdd.yourstoreapp.questions.OrderValidation;
import com.serenitybdd.yourstoreapp.tasks.AcceptTermsAndProceed;
import com.serenitybdd.yourstoreapp.tasks.AddProductToCart;
import com.serenitybdd.yourstoreapp.tasks.ConfirmDeliveryMethod;
import com.serenitybdd.yourstoreapp.tasks.ConfirmOrder;
import com.serenitybdd.yourstoreapp.tasks.FillBillingDetails;
import com.serenitybdd.yourstoreapp.tasks.LookForProduct;
import com.serenitybdd.yourstoreapp.tasks.NavigateTo;
import com.serenitybdd.yourstoreapp.tasks.ProceedToCheckout;
import com.serenitybdd.yourstoreapp.tasks.SelectGuestCheckout;
import com.serenitybdd.yourstoreapp.tasks.ViewShoppingCart;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;


public class CompraProductosStepDefinitions extends BaseClass {

    private static final String PRODUCTO_SESSION_KEY = "PRODUCTO_ACTUAL";

    @Dado("que el usuario ha accedido a la página principal de Your Store App")
    public void queElUsuarioHaAccedidoALaPaginaPrincipalDeYourStoreApp() {
        var actor = getOrCreateActor();
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @Cuando("el usuario agrega dos productos al carrito")
    public void elUsuarioAgregaDosProductosAlCarrito() {
        var actor = context.getCurrentActor();
        actor.attemptsTo(AddProductToCart.named(AppConstants.ProductsNames.PRODUCT_MACKBOOK));
        actor.attemptsTo(AddProductToCart.named(AppConstants.ProductsNames.PRODUCT_IPHONE));
    }

    @Cuando("el usuario busca y agrega {string} al carrito")
    public void elUsuarioBuscaYAgregaAlCarrito(String productName) {
        var actor = context.getCurrentActor();
        actor.attemptsTo(LookForProduct.withName(productName));
        actor.attemptsTo(AddProductToCart.named(productName));
        context.put(PRODUCTO_SESSION_KEY, productName);
    }

    @Y("el usuario visualiza el carrito")
    public void elUsuarioVisualizaElCarrito() {
        var actor = context.getCurrentActor();
        actor.attemptsTo(ViewShoppingCart.click());
        actor.attemptsTo(CartValidation.hasProducts(AppConstants.ProductsNames.PRODUCT_MACKBOOK, AppConstants.ProductsNames.PRODUCT_IPHONE));
        actor.attemptsTo(ProceedToCheckout.start());
    }

    @Y("el usuario completa el checkout como invitado")
    public void elUsuarioCompletaElCheckoutComoInvitado() {
        var actor = context.getCurrentActor();
        actor.attemptsTo(SelectGuestCheckout.option());
        actor.attemptsTo(FillBillingDetails.withDefaultData());
        actor.attemptsTo(ConfirmDeliveryMethod.toNextStep());
        actor.attemptsTo(AcceptTermsAndProceed.toNextStep());
        actor.attemptsTo(ConfirmOrder.now());
    }

    @Y("el usuario visualiza el producto en el carrito")
    public void elUsuarioVisualizaElProductoEnElCarrito() {
        var actor = context.getCurrentActor();
        actor.attemptsTo(ViewShoppingCart.click());
        actor.attemptsTo(CartValidation.hasProducts(context.get(PRODUCTO_SESSION_KEY, String.class)));
        actor.attemptsTo(ProceedToCheckout.start());
    }

    @Entonces("el usuario debería ver la confirmación: Your order has been placed!")
    public void elUsuarioDeberiaVerLaConfirmacionYourOrderHasBeenPlaced() {
        var actor = context.getCurrentActor();
        actor.attemptsTo(OrderValidation.isSuccessful(AppConstants.Messages.MSG_ORDER_SUCCESS));
    }
}
