package co.com.stricentis.tasks;

import co.com.stricentis.models.UserModel;
import co.com.stricentis.userinterface.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class RegisterUser implements Task {

    private final UserModel user;

    public RegisterUser(UserModel user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if ("Male".equalsIgnoreCase(user.getGender())) {
            actor.attemptsTo(Click.on(RegisterPage.GENDER_MALE));
        } else {
            actor.attemptsTo(Click.on(RegisterPage.GENDER_FEMALE));
        }

        actor.attemptsTo(
                Enter.theValue(user.getFirstName()).into(RegisterPage.FIRST_NAME),
                Enter.theValue(user.getLastName()).into(RegisterPage.LAST_NAME),
                Enter.theValue(user.getEmail()).into(RegisterPage.EMAIL),
                Enter.theValue(user.getPassword()).into(RegisterPage.PASSWORD),
                Enter.theValue(user.getPassword()).into(RegisterPage.CONFIRM_PASSWORD),
                Click.on(RegisterPage.REGISTER_BUTTON)
        );
    }

    public static RegisterUser withData(UserModel user) {

        return Tasks.instrumented(RegisterUser.class, user);
    }
}
