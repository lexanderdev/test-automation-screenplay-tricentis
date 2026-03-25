package co.com.stricentis.tasks;

import co.com.stricentis.userinterface.DemoWebShopPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class GoToRegisterPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(DemoWebShopPage.class),
                Click.on(DemoWebShopPage.REGISTER_LINK)
        );
    }

    public static GoToRegisterPage fromHomePage() {

        return Tasks.instrumented(GoToRegisterPage.class);
    }
}
