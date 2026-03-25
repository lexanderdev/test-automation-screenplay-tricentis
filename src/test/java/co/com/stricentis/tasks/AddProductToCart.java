package co.com.stricentis.tasks;

import co.com.stricentis.userinterface.DesktopsPage;
import co.com.stricentis.userinterface.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DesktopsPage.ADD_TO_CART_BUILD_YOUR_OWN_CHEAP_COMPUTER),
                Click.on(ProductDetailPage.ADD_TO_CART_BUTTON)
        );
    }

    public static AddProductToCart buildYourOwnComputer() {
        return Tasks.instrumented(AddProductToCart.class);
    }
}
