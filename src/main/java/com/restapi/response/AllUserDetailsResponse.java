package com.restapi.response;

import com.restapi.model.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AllUserDetailsResponse {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer zipcode;
   private List<AccountResponse> accounts;
}
