package com.restapi.request;

import com.restapi.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private Integer zipcode;

    @NotEmpty
    @Size(min = 2, message = "Username should have at least 2 characters")
    private String username;

    @NotEmpty
    @Size(min = 2, message = "Password should have at least 2 characters")
    private String password;


    private Long acc_type_id;

}
