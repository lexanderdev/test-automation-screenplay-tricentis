package co.com.stricentis.tasks;

import co.com.stricentis.userinterface.CartPage;
import co.com.stricentis.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPage.TERMS_OF_SERVICE_CHECKBOX, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.TERMS_OF_SERVICE_CHECKBOX),
                Click.on(CartPage.PROCEED_TO_CHECKOUT),
                SelectFromOptions.byVisibleText("Colombia").from(CheckoutPage.BILLING_COUNTRY),
                Enter.theValue("Test Company").into(CheckoutPage.BILLING_COMPANY),
                Enter.theValue("Bogota").into(CheckoutPage.BILLING_CITY),
                Enter.theValue("Calle 123 # 45-67").into(CheckoutPage.BILLING_ADDRESS1),
                Enter.theValue("110111").into(CheckoutPage.BILLING_ZIP),
                Enter.theValue("3001234567").into(CheckoutPage.BILLING_PHONE),
                Click.on(CheckoutPage.BILLING_CONTINUE),
                Click.on(CheckoutPage.SHIPPING_ADDRESS_CONTINUE),
                Click.on(CheckoutPage.SHIPPING_METHOD_GROUND),
                Click.on(CheckoutPage.SHIPPING_CONTINUE),
                Click.on(CheckoutPage.PAYMENT_CREDIT_CARD),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE),
                Enter.theValue("Barbara Gordon").into(CheckoutPage.CARDHOLDER_NAME),
                Enter.theValue("4485564059489345").into(CheckoutPage.CARD_NUMBER),
                SelectFromOptions.byVisibleText("04").from(CheckoutPage.CARD_EXPIRE_MONTH),
                SelectFromOptions.byVisibleText("2039").from(CheckoutPage.CARD_EXPIRE_YEAR),
                Enter.theValue("123").into(CheckoutPage.CARD_CODE),
                Click.on(CheckoutPage.PAYMENT_INFO_CONTINUE),
                Click.on(CheckoutPage.CONFIRM_ORDER)
        );
    }

    public static CompleteCheckout withDefaultOptions() {
        return Tasks.instrumented(CompleteCheckout.class);
    }
}
