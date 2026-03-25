package co.com.stricentis.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;

public class SerenityHooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @After
    public void cleanStage() {
        OnStage.drawTheCurtain();
    }
}
