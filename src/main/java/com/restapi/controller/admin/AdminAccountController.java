package com.restapi.controller.admin;

import com.restapi.model.Account;
import com.restapi.request.AccountRequest;
import com.restapi.request.AdminAccountApprovalRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/account")
public class AdminAccountController {

    @Autowired
    private  APIResponse apiResponse;

    @Autowired
    private AccountService accountService;

    @PutMapping("/approval")
    public ResponseEntity<APIResponse> accountApproval(@RequestBody
                                                       AdminAccountApprovalRequest adminAccountApprovalRequest) {
        Account account = accountService.accountApproval(adminAccountApprovalRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(account);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
