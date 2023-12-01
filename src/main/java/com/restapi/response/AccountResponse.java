package com.restapi.response;

import com.restapi.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
//    private List<Account> accountList;

    private Long id;
    private Long account_No;
    private String ifsc_Code;
    private Double balance;
    private String accountType;
    private boolean isApproval;
}
