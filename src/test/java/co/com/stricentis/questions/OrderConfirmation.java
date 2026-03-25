package co.com.stricentis.questions;

import co.com.stricentis.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderConfirmation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutPage.ORDER_CONFIRMATION).answeredBy(actor);
    }

    public static Question<String> message() {
        return new OrderConfirmation();
    }
}
