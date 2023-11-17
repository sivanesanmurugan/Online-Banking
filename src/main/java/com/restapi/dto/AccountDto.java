package com.restapi.dto;

import com.restapi.model.Account;
import com.restapi.repository.AccountTypeRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.AccountRequest;
import com.restapi.request.AdminAccountApprovalRequest;
import com.restapi.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountDto {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private UserRepository userRepository;

    public AccountResponse mapToAccountResponse(Account account) {
        return new AccountResponse(account);
    }

    public Account mapToAccount(AccountRequest accountRequest) {
        Account account = new Account();
        if (accountRequest.getId() != null) {
            account.setId(accountRequest.getId());
        }
        account.setAccount_No(accountRequest.getAccount_No());
        account.setIfsc_Code(accountRequest.getIfsc_Code());
        account.setBalance(accountRequest.getBalance());
        return account;
    }
    public Account mapToAccountApproval(AdminAccountApprovalRequest accountRequest) {
        Account account = new Account();
        if (accountRequest.getId() != null) {
            account.setId(accountRequest.getId());
        }
        account.setBoolean(accountRequest.isBoolean());
        return account;
    }


}