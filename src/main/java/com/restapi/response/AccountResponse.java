package com.restapi.response;

import com.restapi.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponse {
    private Account account;
}
