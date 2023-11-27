package com.restapi.service;

import com.restapi.dto.AccountDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Account;
import com.restapi.model.AccountType;
import com.restapi.model.AppUser;
import com.restapi.repository.AccountRepository;
import com.restapi.repository.AccountTypeRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.AccountRequest;
import com.restapi.request.AdminAccountApprovalRequest;
import com.restapi.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountDto accountDto;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;


    public List<AccountResponse> findAccount(Long id) {
        List<Account> accountList = accountRepository.findUserAccounts(id);
        return accountDto.mapToAccountResponse(accountList);
    }

    public Account createAccount(AccountRequest accountRequest) {
        Account account = accountDto.mapToAccount(accountRequest);
        AppUser appUser = userRepository.findById(accountRequest.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        accountRequest.getUser_id()));
        AccountType accountType = accountTypeRepository.findById(Math.toIntExact((accountRequest.getAcc_type_id())))
                .orElseThrow(() -> new ResourceNotFoundException("acc_type_id", "acc_type_id",
                        accountRequest.getAcc_type_id()));
        account.setUser(appUser);
        account.setAccountType(accountType);
        account = accountRepository.save(account);

        return account;
    }

    public Account updateAccount(AccountRequest accountRequest) {
        Account account = accountDto.mapToAccount(accountRequest);
        AppUser appUser = userRepository.findById(accountRequest.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        accountRequest.getUser_id()));
        AccountType accountType = accountTypeRepository.findById(Math.toIntExact((accountRequest.getAcc_type_id())))
                .orElseThrow(() -> new ResourceNotFoundException("acc_type_id", "acc_type_id",
                        accountRequest.getAcc_type_id()));
        account.setUser(appUser);
        account.setAccountType(accountType);
        accountRepository.save(account);
        return account;
    }

    public String accountApproval(Long id) {
        accountRepository.updateUser(id);
        return "Success";
    }

    public List<Account> accountNotApproval() {
        return accountRepository.findByNotApprovalUsers();
    }

    public List<Account> findSameBankAccount(Long id) {
        return accountRepository.findAll()
                .stream()
                .filter(account -> !account.getAccount_No().equals(id))
                .toList();
    }
}
