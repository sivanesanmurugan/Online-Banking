package com.restapi.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Getter
@Setter
public class RegisterResponse {
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private Integer zipcode;

    private String username;

    private String password;

    private Long account_No;

    private String accountType;
}
