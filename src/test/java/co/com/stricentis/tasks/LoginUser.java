package co.com.stricentis.tasks;

import co.com.stricentis.models.LoginModel;
import co.com.stricentis.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginUser implements Task {

    private final LoginModel credentials;

    public LoginUser(LoginModel credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credentials.getEmail()).into(LoginPage.EMAIL),
                Enter.theValue(credentials.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static LoginUser withCredentials(LoginModel credentials) {
        return Tasks.instrumented(LoginUser.class, credentials);
    }
}
