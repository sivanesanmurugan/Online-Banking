package com.restapi.dataloader;

import com.restapi.model.*;
import com.restapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

//        Create user roles
        Role userRole = createRoleIfNotFound(Role.USER);
        Role adminRole = createRoleIfNotFound(Role.ADMIN);
//        Create user
        createUserIfNotFound("user", "user", userRole);
        createUserIfNotFound("admin", "admin", adminRole);

        createTypeIfNotFound(AccountType.SAVING_ACCOUNT);
        createTypeIfNotFound(AccountType.INVESTMENT_ACCOUNT);

// create transactionType
        createTransactionTypeIfNotFound(TransactionType.selfTransaction);
        createTransactionTypeIfNotFound(TransactionType.sameBankTransaction);
        createTransactionTypeIfNotFound(TransactionType.otherBankTransaction);


//        create status
        createMessage("SUCCESSFULLY");
        createMessage("PENDING");
        createMessage("CANCELLED");

        alreadySetup = true;
    }


    private void createMessage(String status) {
        transactionStatusRepository.save(new TransactionStatus(status));
    }

    @Transactional
    private Role createRoleIfNotFound(final String username) {
        Role role = roleRepository.findByName(username);
        if (role == null) {
            role = new Role();
            role.setName(username);
            role = roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private void createUserIfNotFound(final String username, final String password,
                                      final Role role) {
        Optional<AppUser> optionalUser = userRepository.findByUsername(username);
        AppUser user = null;
        if (optionalUser.isEmpty()) {
            user = new AppUser();
            user.setUsername(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setRole(role);
            userRepository.save(user);
        }
    }

    private void createTypeIfNotFound(String typeName) {
        AccountType accountType = accountTypeRepository.findByAccountType(typeName);
        if (accountType == null) {
            accountType = new AccountType();
            accountType.setAccountType(typeName);
            accountTypeRepository.save(accountType);
        }
    }

    private void createTransactionTypeIfNotFound(String typeName) {
        TransactionType transactionType = transactionTypeRepository.findByTransactionTypeName(typeName);
        if (transactionType == null) {
            transactionType = new TransactionType();
            transactionType.setTransactionTypeName(typeName);
            transactionTypeRepository.save(transactionType);
        }
    }
}
