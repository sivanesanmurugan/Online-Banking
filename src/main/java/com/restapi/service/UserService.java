package com.restapi.service;

import com.restapi.dto.AccountDto;
import com.restapi.dto.AuthDto;
import com.restapi.dto.AuthDto;
import com.restapi.exception.common.AppException;
import com.restapi.exception.common.InvalidUserException;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.*;
import com.restapi.repository.*;
import com.restapi.request.LoginRequest;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private AuthDto authDto;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    UserDetailRepository userDetailRepository;
    @Autowired
    AccountTypeRepository accountTypeRepository;

    public AuthResponse register(RegisterRequest registerRequest) {
        AppUser appUser = authDto.mapToAppUser(registerRequest);
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRole(roleRepository.findByName(Role.USER));
        appUser = userRepository.save(appUser);

        Account account = new Account();
        Long generatedAccountNumber;

        do {
            generatedAccountNumber = autoGenerate();
        } while (isAccountNumberExists(generatedAccountNumber));

        account.setAccount_No(generatedAccountNumber);

        AccountType accountType = accountTypeRepository.findById(Math.toIntExact(registerRequest.getAcc_type_id()))
                .orElseThrow(() -> new ResourceNotFoundException("acc_type_id", "acc_type_id",
                        registerRequest.getAcc_type_id()));

        account.setAccountType(accountType);
        account.setUser(appUser);
        accountRepository.save(account);

        UserDetail userDetail = getUserDetail(registerRequest, appUser);
        userDetailRepository.save(userDetail);

        return authDto.mapToAuthResponse(appUser);
    }

    public boolean isAccountNumberExists(Long accountNumber) {
        return accountRepository.existsByAccount_No(accountNumber);
    }

    public static Long autoGenerate() {
        Random random = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;
        return lowerBound + Math.abs(random.nextLong()) % (upperBound - lowerBound + 1);
    }
    private static UserDetail getUserDetail(RegisterRequest registerRequest, AppUser appUser) {
        UserDetail userDetail=new UserDetail();
        userDetail.setFirstName(registerRequest.getFirstName());
        userDetail.setLastName(registerRequest.getLastName());
        userDetail.setEmail(registerRequest.getEmail());
        userDetail.setPhone(registerRequest.getPhone());
        userDetail.setAddress(registerRequest.getAddress());
        userDetail.setCity(registerRequest.getCity());
        userDetail.setState(registerRequest.getState());
        userDetail.setZipcode(registerRequest.getZipcode());
        userDetail.setAppUser(appUser);
        return userDetail;
    }

    private Long generateAccountNumber() {
        return null;
    }

    public AuthResponse login(LoginRequest loginRequest) {
        AppUser appUser = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new InvalidUserException("Invalid user credentials"));

        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), appUser.getPassword())) {
            throw new InvalidUserException("Invalid password");
        }

        return authDto.mapToAuthResponse(appUser);
    }
    public List<AppUser> findAll() {
     return userRepository.findAll();
    }


}
