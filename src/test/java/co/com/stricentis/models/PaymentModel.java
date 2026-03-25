package co.com.stricentis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentModel {

    private String cardholderName;
    private String cardNumber;
    private String cardExpireMonth;
    private String cardExpireYear;
    private String cardCode;
}
