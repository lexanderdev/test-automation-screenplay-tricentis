package co.com.stricentis.questions;

import co.com.stricentis.userinterface.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegistrationResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(RegisterPage.SUCCESS_MESSAGE).answeredBy(actor);
    }

    public static Question<String> displayed() {

        return new RegistrationResult();
    }
}
