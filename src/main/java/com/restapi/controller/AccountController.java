package com.restapi.controller;

import com.restapi.model.Account;
import com.restapi.request.AccountRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findAccount(@PathVariable Long id){
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(accountService.findAccount(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/findAcc/{id}")
    public ResponseEntity<APIResponse> findByAccount(@PathVariable Long id){
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(accountService.findByAccount(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<APIResponse> createAccount(@RequestBody
                                                     AccountRequest accountRequest) {
        Account account = accountService.createAccount(accountRequest);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(account);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<APIResponse> updateAccount(@RequestBody
                                                         AccountRequest accountRequest) {
        Account account = accountService.updateAccount(accountRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(account);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

   @GetMapping("/sameBank/{id}")
   public ResponseEntity<APIResponse> findSameBankUser(@PathVariable Long id){
       List<Account> accountList=accountService.findSameBankAccount(id);
       apiResponse.setStatus(HttpStatus.OK.value());
       apiResponse.setData(accountList);
       return new ResponseEntity<>(apiResponse, HttpStatus.OK);
   }
}
