package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    public static final Target TERMS_OF_SERVICE_CHECKBOX = Target.the("checkbox terminos de servicio")
            .located(By.cssSelector("#termsofservice"));

    public static final Target PROCEED_TO_CHECKOUT = Target.the("boton proceder al checkout")
            .located(By.cssSelector(".checkout-buttons .button-1"));
}
