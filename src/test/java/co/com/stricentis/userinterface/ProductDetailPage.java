package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailPage extends PageObject {

    public static final Target ADD_TO_CART_BUTTON = Target.the("boton agregar al carrito en detalle del producto")
            .located(By.cssSelector(".add-to-cart-button"));

    public static final Target BAR_NOTIFICATION = Target.the("notificacion de producto agregado")
            .located(By.cssSelector("#bar-notification"));

    public static final Target CART_LINK_IN_NOTIFICATION = Target.the("link al carrito en la notificacion")
            .located(By.cssSelector("#bar-notification .content a"));
}
