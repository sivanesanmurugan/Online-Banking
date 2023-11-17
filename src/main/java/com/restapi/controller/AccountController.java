package com.restapi.controller;

import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Account;
import com.restapi.model.AccountType;
import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.request.AccountRequest;
import com.restapi.request.AddressRequest;
import com.restapi.response.AccountResponse;
import com.restapi.response.AddressResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

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

//    @DeleteMapping("/{id}")
//    public ResponseEntity<APIResponse> deleteAccount(@PathVariable Integer id) {
//        AccountResponse accountResponse = accountService
//                .deleteById(Long.valueOf(id));
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(accountResponse);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
}
