package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target EMAIL         = Target.the("campo email").located(By.id("Email"));
    public static final Target PASSWORD      = Target.the("campo contrasena").located(By.id("Password"));
    public static final Target LOGIN_BUTTON  = Target.the("boton iniciar sesion").located(By.cssSelector(".login-button"));
    public static final Target ERROR_MESSAGE = Target.the("mensaje de error").located(By.cssSelector(".message-error li"));
    public static final Target ACCOUNT_LINK  = Target.the("link de cuenta").located(By.cssSelector("a.account"));
}
