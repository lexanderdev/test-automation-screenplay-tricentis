package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DesktopsPage extends PageObject {

    public static final Target ADD_TO_CART_BUILD_YOUR_OWN_CHEAP_COMPUTER = Target.the("boton agregar al carrito de Build your own cheap computer")
            .located(By.cssSelector("[data-productid='72'] .product-box-add-to-cart-button"));

    public static final Target CART_NOTIFICATION = Target.the("notificacion de producto agregado")
            .located(By.cssSelector("#bar-notification .content"));

    public static final Target CART_LINK = Target.the("link del carrito")
            .located(By.cssSelector("a.ico-cart"));
}
