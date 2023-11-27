package com.restapi.controller;

import com.restapi.model.Account;
import com.restapi.model.Transaction;
import com.restapi.request.AccountRequest;
import com.restapi.request.TransactionRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/transaction")
public class TransactionController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/self")
    public ResponseEntity<APIResponse> selfTransaction(@RequestBody
                                                         TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.createSelfTransaction(transactionRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(transaction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{accountNo}")
    public ResponseEntity<APIResponse> getTransaction(@PathVariable Long accountNo) {
        List<Transaction> transactions = transactionService.findAccountTransaction(accountNo);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(transactions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/sameBank")
    public ResponseEntity<APIResponse> sameBankTransaction(@RequestBody
                                                   TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.createSelfTransaction(transactionRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(transaction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/otherBank")
    public ResponseEntity<APIResponse> otherBankTransaction(@RequestBody
                                                           TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.createOtherBankTransaction(transactionRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(transaction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
