package com.restapi.repository;

import com.restapi.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
    AccountType findByAccountType(String accountType);

    AccountType findByAccountType(Long accTypeId);

}
