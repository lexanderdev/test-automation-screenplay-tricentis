package co.com.stricentis.userinterface;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    public static final Target GENDER_MALE      = Target.the("radio boton masculino").located(By.id("gender-male"));
    public static final Target GENDER_FEMALE    = Target.the("radio boton femenino").located(By.id("gender-female"));
    public static final Target FIRST_NAME       = Target.the("campo nombre").located(By.id("FirstName"));
    public static final Target LAST_NAME        = Target.the("campo apellido").located(By.id("LastName"));
    public static final Target EMAIL            = Target.the("campo email").located(By.id("Email"));
    public static final Target PASSWORD         = Target.the("campo contrasena").located(By.id("Password"));
    public static final Target CONFIRM_PASSWORD = Target.the("campo confirmar contrasena").located(By.id("ConfirmPassword"));
    public static final Target REGISTER_BUTTON  = Target.the("boton registrar").located(By.id("register-button"));
    public static final Target SUCCESS_MESSAGE  = Target.the("mensaje de exito").located(By.cssSelector(".result"));
    public static final Target ERROR_MESSAGE    = Target.the("mensaje de error").located(By.cssSelector(".message-error li"));
}
