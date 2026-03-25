package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

    public static final Target BILLING_COUNTRY         = Target.the("selector de pais en billing")
            .located(By.id("BillingNewAddress_CountryId"));

    public static final Target BILLING_COMPANY         = Target.the("campo empresa en billing")
            .located(By.id("BillingNewAddress_Company"));

    public static final Target BILLING_CITY            = Target.the("campo ciudad en billing")
            .located(By.id("BillingNewAddress_City"));

    public static final Target BILLING_ADDRESS1        = Target.the("campo direccion 1 en billing")
            .located(By.id("BillingNewAddress_Address1"));

    public static final Target BILLING_ZIP             = Target.the("campo codigo postal en billing")
            .located(By.id("BillingNewAddress_ZipPostalCode"));

    public static final Target BILLING_PHONE           = Target.the("campo telefono en billing")
            .located(By.id("BillingNewAddress_PhoneNumber"));

    public static final Target BILLING_CONTINUE        = Target.the("boton continuar en billing")
            .located(By.cssSelector("#billing-buttons-container .new-address-next-step-button"));

    public static final Target SHIPPING_ADDRESS_CONTINUE = Target.the("boton continuar en shipping address")
            .located(By.cssSelector("#shipping-buttons-container .button-1"));

    public static final Target SHIPPING_METHOD_GROUND  = Target.the("metodo de envio ground")
            .located(By.cssSelector("input[id*='shippingoption_']"));

    public static final Target SHIPPING_CONTINUE       = Target.the("boton continuar en shipping method")
            .located(By.cssSelector("#shipping-method-buttons-container .button-1"));

    public static final Target PAYMENT_CREDIT_CARD     = Target.the("metodo de pago tarjeta de credito")
            .located(By.cssSelector("input[value='Payments.Manual']"));

    public static final Target PAYMENT_METHOD_CONTINUE = Target.the("boton continuar en payment method")
            .located(By.cssSelector("#payment-method-buttons-container .button-1"));

    public static final Target CARDHOLDER_NAME         = Target.the("campo nombre del titular de la tarjeta")
            .located(By.id("CardholderName"));

    public static final Target CARD_NUMBER             = Target.the("campo numero de tarjeta")
            .located(By.id("CardNumber"));

    public static final Target CARD_EXPIRE_MONTH       = Target.the("selector mes de expiracion")
            .located(By.id("ExpireMonth"));

    public static final Target CARD_EXPIRE_YEAR        = Target.the("selector año de expiracion")
            .located(By.id("ExpireYear"));

    public static final Target CARD_CODE               = Target.the("campo codigo de tarjeta")
            .located(By.id("CardCode"));

    public static final Target PAYMENT_INFO_CONTINUE   = Target.the("boton continuar en payment info")
            .located(By.cssSelector(".payment-info-next-step-button"));

    public static final Target CONFIRM_ORDER           = Target.the("boton confirmar orden")
            .located(By.cssSelector(".confirm-order-next-step-button"));

    public static final Target ORDER_CONFIRMATION      = Target.the("mensaje de confirmacion de orden")
            .located(By.cssSelector(".order-completed .title"));
}
