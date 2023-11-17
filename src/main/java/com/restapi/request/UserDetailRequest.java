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

    private String firstname;

    private String lastname;

    private String email;

    private String phone;

    private Long user_Id;
}
