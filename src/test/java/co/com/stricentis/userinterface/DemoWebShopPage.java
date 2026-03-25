package co.com.stricentis.userinterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url")
public class DemoWebShopPage extends PageObject {

    public static final Target REGISTER_LINK = Target.the("link de registro").located(By.cssSelector("a.ico-register"));
    public static final Target LOGIN_LINK    = Target.the("link de inicio de sesion").located(By.cssSelector("a.ico-login"));
}
