package co.com.stricentis.stepdefinitions;

import co.com.stricentis.models.UserModel;
import co.com.stricentis.tasks.GoToRegisterPage;
import co.com.stricentis.userinterface.RegisterPage;
import co.com.stricentis.questions.RegistrationResult;
import co.com.stricentis.tasks.RegisterUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Map;

public class RegisterStepDefinitions {

    @Given("el usuario navega a la pagina de registro")
    public void elUsuarioNavegaALaPaginaDeRegistro() {
        OnStage.theActorCalled("Alex").attemptsTo(
                GoToRegisterPage.fromHomePage()
        );
    }

    @When("el usuario completa el formulario de registro")
    public void elUsuarioCompletaElFormularioDeRegistro(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        UserModel user = UserModel.builder()
                .gender(data.get("gender"))
                .firstName(data.get("firstName"))
                .lastName(data.get("lastName"))
                .email(data.get("email"))
                .password(data.get("password"))
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withData(user)
        );
    }

    @Then("el registro se completa exitosamente")
    public void elRegistroSeCompletaExitosamente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(RegistrationResult.displayed())
                        .isEqualTo("Your registration completed")
        );
    }

    @Then("el usuario ve el error {string}")
    public void elUsuarioVeElError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(RegisterPage.ERROR_MESSAGE).answeredBy(OnStage.theActorInTheSpotlight()))
                        .isEqualTo(mensajeEsperado)
        );
    }
}
