package com.restapi.repository;

import com.restapi.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus,Integer> {
}
