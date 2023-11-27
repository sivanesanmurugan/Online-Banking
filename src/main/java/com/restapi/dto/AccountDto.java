package com.restapi.dto;

import com.restapi.model.Account;
import com.restapi.repository.AccountTypeRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.AccountRequest;
import com.restapi.request.AdminAccountApprovalRequest;
import com.restapi.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDto {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AccountResponse> mapToAccountResponse(List<Account> account) {
        List<AccountResponse> accountResponseList = new ArrayList<>();

        for(Account acc : account)
        {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setId(acc.getId());
            accountResponse.setAccount_No(acc.getAccount_No());
            accountResponse.setIfsc_code(acc.getIfsc_Code());
            accountResponse.setBalance(acc.getBalance());
            accountResponse.setAccountType(acc.getAccountType().getAccountType());
            accountResponseList.add(accountResponse);

        }
        return  accountResponseList;
    }

    public Account mapToAccount(AccountRequest accountRequest) {
        Account account = new Account();
        if (accountRequest.getId() != null) {
            account.setId(accountRequest.getId());
        }
        account.setAccount_No(accountRequest.getAccount_No());
        return account;
    }



}