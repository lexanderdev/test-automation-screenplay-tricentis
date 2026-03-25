package co.com.stricentis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingModel {

    private String country;
    private String company;
    private String city;
    private String address;
    private String zip;
    private String phone;
}
