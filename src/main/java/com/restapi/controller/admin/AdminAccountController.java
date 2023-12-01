package com.restapi.controller.admin;

import com.restapi.model.Account;
import com.restapi.model.Transaction;
import com.restapi.request.AccountRequest;
import com.restapi.request.AdminAccountApprovalRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AccountService;
import com.restapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/account")
public class AdminAccountController {

    @Autowired
    private  APIResponse apiResponse;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/approval/{id}")
    public ResponseEntity<APIResponse> accountApproval(@PathVariable Long id) {
        String approvalResponse = accountService.accountApproval(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(approvalResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/notApproval")
    public ResponseEntity<APIResponse> accountNotApproval() {
        List<Account> account = accountService.accountNotApproval();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(account);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/transaction")
    public ResponseEntity<APIResponse> getAllTransaction() {
        List<Transaction> transactions = transactionService.getAllTransaction();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(transactions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
