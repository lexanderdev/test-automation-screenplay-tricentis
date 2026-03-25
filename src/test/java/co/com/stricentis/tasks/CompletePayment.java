package co.com.stricentis.tasks;

import co.com.stricentis.models.PaymentModel;
import co.com.stricentis.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class CompletePayment implements Task {

    private final PaymentModel payment;

    public CompletePayment(PaymentModel payment) {
        this.payment = payment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.PAYMENT_CREDIT_CARD),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE),
                Enter.theValue(payment.getCardholderName()).into(CheckoutPage.CARDHOLDER_NAME),
                Enter.theValue(payment.getCardNumber()).into(CheckoutPage.CARD_NUMBER),
                SelectFromOptions.byVisibleText(payment.getCardExpireMonth()).from(CheckoutPage.CARD_EXPIRE_MONTH),
                SelectFromOptions.byVisibleText(payment.getCardExpireYear()).from(CheckoutPage.CARD_EXPIRE_YEAR),
                Enter.theValue(payment.getCardCode()).into(CheckoutPage.CARD_CODE),
                Click.on(CheckoutPage.PAYMENT_INFO_CONTINUE),
                Click.on(CheckoutPage.CONFIRM_ORDER)
        );
    }

    public static CompletePayment withData(PaymentModel payment) {
        return Tasks.instrumented(CompletePayment.class, payment);
    }
}
