package co.com.stricentis.questions;

import co.com.stricentis.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class LoginResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(LoginPage.ACCOUNT_LINK).answeredBy(actor);
    }

    public static Question<Boolean> isSuccessful() {
        return new LoginResult();
    }
}
