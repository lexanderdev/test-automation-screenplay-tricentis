package co.com.stricentis.tasks;

import co.com.stricentis.models.BillingModel;
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

    private final BillingModel billing;

    public CompleteCheckout(BillingModel billing) {
        this.billing = billing;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPage.TERMS_OF_SERVICE_CHECKBOX, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.TERMS_OF_SERVICE_CHECKBOX),
                Click.on(CartPage.PROCEED_TO_CHECKOUT),
                SelectFromOptions.byVisibleText(billing.getCountry()).from(CheckoutPage.BILLING_COUNTRY),
                Enter.theValue(billing.getCompany()).into(CheckoutPage.BILLING_COMPANY),
                Enter.theValue(billing.getCity()).into(CheckoutPage.BILLING_CITY),
                Enter.theValue(billing.getAddress()).into(CheckoutPage.BILLING_ADDRESS1),
                Enter.theValue(billing.getZip()).into(CheckoutPage.BILLING_ZIP),
                Enter.theValue(billing.getPhone()).into(CheckoutPage.BILLING_PHONE),
                Click.on(CheckoutPage.BILLING_CONTINUE),
                Click.on(CheckoutPage.SHIPPING_ADDRESS_CONTINUE),
                Click.on(CheckoutPage.SHIPPING_METHOD_GROUND),
                Click.on(CheckoutPage.SHIPPING_CONTINUE)
        );
    }

    public static CompleteCheckout withBilling(BillingModel billing) {
        return Tasks.instrumented(CompleteCheckout.class, billing);
    }
}
