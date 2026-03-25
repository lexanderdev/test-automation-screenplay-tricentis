package co.com.stricentis.stepdefinitions;

import co.com.stricentis.models.BillingModel;
import co.com.stricentis.models.PaymentModel;
import co.com.stricentis.questions.OrderConfirmation;
import co.com.stricentis.tasks.AddProductToCart;
import co.com.stricentis.tasks.CompleteCheckout;
import co.com.stricentis.tasks.CompletePayment;
import co.com.stricentis.tasks.SelectSubCategory;
import co.com.stricentis.userinterface.ProductDetailPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Presence;

import java.util.Map;

public class PurchaseStepDefinitions {

    @When("el usuario navega a la subcategoria {string} dentro de {string}")
    public void elUsuarioNavegaALaSubcategoria(String subCategory, String category) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectSubCategory.withName(category, subCategory)
        );
    }

    @And("el usuario agrega Build your own cheap computer al carrito")
    public void elUsuarioAgregaAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.buildYourOwnComputer()
        );
    }

    @And("el usuario va al carrito desde la notificacion")
    public void elUsuarioVaAlCarritoDesdeNotificacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProductDetailPage.CART_LINK_IN_NOTIFICATION)
        );
    }

    @And("el usuario completa el proceso de compra con direccion")
    public void elUsuarioCompletaElProcesoDeCompraConDireccion(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        BillingModel billing = BillingModel.builder()
                .country(data.get("country"))
                .company(data.get("company"))
                .city(data.get("city"))
                .address(data.get("address"))
                .zip(data.get("zip"))
                .phone(data.get("phone"))
                .build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withBilling(billing)
        );
    }

    @And("el usuario paga con tarjeta de credito")
    public void elUsuarioPagaConTarjetaDeCredito(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        PaymentModel payment = PaymentModel.builder()
                .cardholderName(data.get("cardholderName"))
                .cardNumber(data.get("cardNumber"))
                .cardExpireMonth(data.get("month"))
                .cardExpireYear(data.get("year"))
                .cardCode(data.get("code"))
                .build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletePayment.withData(payment)
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

    @And("el usuario ve la confirmacion de su orden")
    public void elUsuarioVeLaConfirmacionDeSuOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(OrderConfirmation.message())
                        .isEqualTo("Your order has been successfully processed!")
        );
    }
}
