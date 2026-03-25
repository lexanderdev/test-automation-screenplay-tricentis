package co.com.stricentis.models;

import lombok.Builder;
import lombok.Data;

//se implementa el patron builder para facilitar la creacion
// de objetos de tipo UserModel en los step definitions,
@Data
@Builder
public class UserModel {
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
