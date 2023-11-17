package com.restapi.repository;

import com.restapi.model.AccountType;
import com.restapi.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,Long> {
    TransactionType findByTransactionTypeName(String transactionTypeName);
}
