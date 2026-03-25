package co.com.stricentis.stepdefinitions;

import co.com.stricentis.models.LoginModel;
import co.com.stricentis.questions.LoginResult;
import co.com.stricentis.tasks.GoToLoginPage;
import co.com.stricentis.tasks.LoginUser;
import co.com.stricentis.userinterface.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Map;

public class LoginStepDefinitions {

    @Given("el usuario navega a la pagina de inicio de sesion")
    public void elUsuarioNavegaALaPaginaDeInicioSesion() {
        OnStage.theActorCalled("Alex").attemptsTo(
                GoToLoginPage.fromHomePage()
        );
    }

    @When("el usuario inicia sesion con sus credenciales")
    public void elUsuarioIniciaSesionConSusCredenciales(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();

        LoginModel credentials = LoginModel.builder()
                .email(data.get("email"))
                .password(data.get("password"))
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.withCredentials(credentials)
        );
    }

    @Then("el usuario accede exitosamente a su cuenta")
    public void elUsuarioAccedeExitosamenteASuCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginResult.isSuccessful()).isTrue()
        );
    }

    @Then("el usuario ve el mensaje de error {string}")
    public void elUsuarioVeElMensajeDeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(LoginPage.ERROR_MESSAGE).answeredBy(OnStage.theActorInTheSpotlight()))
                        .isEqualTo(mensajeEsperado)
        );
    }
}
