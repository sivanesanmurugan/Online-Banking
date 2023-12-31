package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountRequest {
    private Long id;

    private Long account_No;

    private String ifsc_Code;

    private Double balance;

    private Long user_id;

    private Long acc_type_id;

    private boolean isBoolean;
}
