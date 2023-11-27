package com.restapi.repository;

import com.restapi.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,Long> {
    TransactionType findByTransactionTypeName(String transactionTypeName);

//    @Query("Select t from TransactionType t where t.id=?1")
//    <Optional>TransactionType findById(Long id);


}
