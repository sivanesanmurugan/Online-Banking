package com.restapi.service;

import com.restapi.exception.common.InsufficientBalance;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.*;
import com.restapi.repository.AccountRepository;
import com.restapi.repository.TransactionRepository;
import com.restapi.repository.TransactionStatusRepository;
import com.restapi.repository.TransactionTypeRepository;
import com.restapi.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    public Transaction createSelfTransaction(TransactionRequest transactionRequest) {
        System.out.println(transactionRequest.getAmount());
        Account source = accountRepository.findsoureAccount(transactionRequest.getSourceAccount());
        Account target = accountRepository.findtargetAccount(transactionRequest.getTargetAccount());
        Optional<TransactionType> transactionType = transactionTypeRepository.findById(transactionRequest.getTransactionType());
        Optional<TransactionStatus> transactionStatus = transactionStatusRepository.findById(transactionRequest.getTransactionStatus());
            double sourceBalance = source.getBalance();
            if (sourceBalance < transactionRequest.getAmount()) {
                System.out.println("insufficient balance");
                throw new InsufficientBalance();
            }
            double newSourceBalance = source.getBalance() - transactionRequest.getAmount();
            source.setBalance(newSourceBalance);
            accountRepository.save(source);
            double targetBalance = target.getBalance();
            double newTargetBalance = targetBalance + transactionRequest.getAmount();
            target.setBalance(newTargetBalance);
            accountRepository.save(target);

            Transaction transaction = new Transaction();
            if(transactionType.isPresent()&&transactionStatus.isPresent()) {
                System.out.println(transactionRequest.getSourceAccount());
                transaction.setSourceAccount(transactionRequest.getSourceAccount());
                transaction.setTargetAccount(transactionRequest.getTargetAccount());
                transaction.setAmount(transactionRequest.getAmount());
                transaction.setTransactionType(transactionType.get());
                transaction.setTransactionStatus(transactionStatus.get());
                transactionRepository.save(transaction);
            }
        return transaction;
    }

    public List<Transaction> findAccountTransaction(Long accountNo) {
        return transactionRepository.findAccountTransaction(accountNo,accountNo)
                .stream()
                .sorted((t1, t2) -> t2.getLocalDateTime().compareTo(t1.getLocalDateTime()))
                .toList();
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public Transaction createOtherBankTransaction(TransactionRequest transactionRequest) {
        Account source = accountRepository.findsoureAccount(transactionRequest.getSourceAccount());
        Optional<TransactionType> transactionType = transactionTypeRepository.findById(transactionRequest.getTransactionType());
        Optional<TransactionStatus> transactionStatus = transactionStatusRepository.findById(transactionRequest.getTransactionStatus());
        Transaction transaction = new Transaction();
        if (transactionType.isPresent() && transactionStatus.isPresent()) {
            double sourceBalance = source.getBalance();
            if (sourceBalance < transactionRequest.getAmount()) {
                throw new InsufficientBalance();
            }
            double newSourceBalance = source.getBalance() - transactionRequest.getAmount();
            source.setBalance(newSourceBalance);
            accountRepository.save(source);

            transaction.setSourceAccount(transactionRequest.getSourceAccount());
            transaction.setTargetAccount(transactionRequest.getTargetAccount());
            transaction.setAmount(transactionRequest.getAmount());
            transaction.setTransactionType(transactionType.get());
            transaction.setTransactionStatus(transactionStatus.get());
            transactionRepository.save(transaction);
        }
        return transaction;
    }
}

