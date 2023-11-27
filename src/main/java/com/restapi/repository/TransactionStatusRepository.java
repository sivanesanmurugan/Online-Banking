package com.restapi.repository;

import com.restapi.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus,Integer> {

    Optional<TransactionStatus> findById(Long transactionStatus);

    TransactionStatus findByStatusName(String status);
}
