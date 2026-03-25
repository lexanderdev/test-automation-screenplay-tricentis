package co.com.stricentis.stepdefinitions;

import co.com.stricentis.questions.OrderConfirmation;
import co.com.stricentis.tasks.AddProductToCart;
import co.com.stricentis.tasks.CompleteCheckout;
import co.com.stricentis.tasks.SelectSubCategory;
import co.com.stricentis.userinterface.CategoriesMenu;
import co.com.stricentis.userinterface.DesktopsPage;
import co.com.stricentis.userinterface.ProductDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

public class ComputersStepDefinitions {

    @When("el usuario navega a la subcategoria {string} dentro de {string}")
    public void elUsuarioNavegaALaSubcategoria(String subCategory, String category) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectSubCategory.withName(category, subCategory)
        );
    }

    @And("el usuario agrega {string} al carrito")
    public void elUsuarioAgregaAlCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.buildYourOwnComputer()
        );
    }

    @And("el usuario completa el proceso de compra")
    public void elUsuarioCompletaElProcesodeCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withDefaultOptions()
        );
    }

    @And("el usuario va al carrito desde la notificacion")
    public void elUsuarioVaAlCarritoDesdeNotificacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProductDetailPage.CART_LINK_IN_NOTIFICATION)
        );
    }

    @Then("el usuario ve la notificacion de producto agregado al carrito")
    public void elUsuarioVeLaNotificacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Presence.of(ProductDetailPage.BAR_NOTIFICATION)
                        .answeredBy(OnStage.theActorInTheSpotlight()))
                        .isTrue()
        );
    }

    @Then("el usuario ve la confirmacion de su orden")
    public void elUsuarioVeLaConfirmacionDeSuOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(OrderConfirmation.message())
                        .isEqualTo("Your order has been successfully processed!")
        );
    }

    @Then("el usuario ve la pagina de {string}")
    public void elUsuarioVeLaPaginaDe(String expectedTitle) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(CategoriesMenu.PAGE_TITLE)
                        .answeredBy(OnStage.theActorInTheSpotlight()))
                        .isEqualTo(expectedTitle)
        );
    }
}
