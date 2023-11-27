package com.restapi.repository;

import com.restapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("SELECT t FROM Transaction t WHERE t.sourceAccount = ?1 OR t.targetAccount = ?2")
    List<Transaction> findAccountTransaction(Long sourceAccountNumber,Long targetAccountNo);
}
