package com.restapi.repository;

import com.restapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAllById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.isBoolean=true WHERE a.id=?1")
    void updateUser(Long id);

    @Query("select a from Account a where a.isBoolean = false")
    List<Account> findByNotApprovalUsers();

    @Query("select d from Account d inner join d.user a where a.id=?1")
    List<Account> findUserAccounts(Long id);

    @Query("select a from Account a where a.account_No =?1")
    Account findsoureAccount(Long sourceAccount);
    @Query("select a from Account a where a.account_No =?1")
    Account findtargetAccount(Long targetAccount);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.account_No = ?1")
    boolean existsByAccount_No(Long accountNo);
}
