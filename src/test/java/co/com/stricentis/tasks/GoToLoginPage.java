package co.com.stricentis.tasks;

import co.com.stricentis.userinterface.DemoWebShopPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class GoToLoginPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(DemoWebShopPage.class),
                Click.on(DemoWebShopPage.LOGIN_LINK)
        );
    }

    public static GoToLoginPage fromHomePage() {
        return Tasks.instrumented(GoToLoginPage.class);
    }
}
