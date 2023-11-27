package com.restapi.request;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailRequest {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private Integer zipcode;

    private Long user_Id;
}
