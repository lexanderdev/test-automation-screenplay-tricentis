package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DesktopsPage extends PageObject {

    public static final Target ADD_TO_CART_BUILD_YOUR_OWN_CHEAP_COMPUTER = Target.the("boton agregar al carrito de Build your own cheap computer")
            .located(By.cssSelector("[data-productid='72'] .product-box-add-to-cart-button"));

}
