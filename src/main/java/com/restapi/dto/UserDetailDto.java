package com.restapi.dto;

import com.restapi.model.Account;
import com.restapi.model.AppUser;
import com.restapi.model.UserDetail;
import com.restapi.request.AccountRequest;
import com.restapi.request.UserDetailRequest;
import com.restapi.response.AccountResponse;
import com.restapi.response.AllUserDetailsResponse;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserDetailResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailDto {

    public UserDetail mapToUserDetail(UserDetailRequest userDetailRequest) {
        UserDetail userDetail = new UserDetail();
        if (userDetailRequest.getId() != null) {
            userDetail.setId(userDetailRequest.getId());
        }
        userDetail.setFirstName(userDetailRequest.getFirstName());
        userDetail.setLastName(userDetailRequest.getLastName());
        userDetail.setEmail(userDetailRequest.getEmail());
        userDetail.setPhone(userDetailRequest.getPhone());
        userDetail.setAddress(userDetailRequest.getAddress());
        userDetail.setCity(userDetailRequest.getCity());
        userDetail.setState(userDetailRequest.getState());
        userDetail.setZipcode(userDetailRequest.getZipcode());
        return userDetail;
    }


    public UserDetailResponse mapToUserDetailResponse(UserDetail userDetail) {
        return new UserDetailResponse(userDetail);
    }

    public List<AllUserDetailsResponse> mapToAllUser(List<AppUser> allUser) {
       List<AllUserDetailsResponse> allUserDetailsResponse=  new ArrayList<>();
        for (AppUser user:allUser) {
          AllUserDetailsResponse userDetails= new AllUserDetailsResponse();
          userDetails.setUsername(user.getUsername());
          userDetails.setFirstName(user.getUserDetail().getFirstName());
          userDetails.setLastName(user.getUserDetail().getLastName());
          userDetails.setEmail(user.getUserDetail().getEmail());
          userDetails.setPhone(user.getUserDetail().getPhone());
          userDetails.setAddress(user.getUserDetail().getAddress());
          userDetails.setCity(user.getUserDetail().getCity());
          userDetails.setState(user.getUserDetail().getState());
          userDetails.setZipcode(user.getUserDetail().getZipcode());
            List<AccountResponse> accountResponses = new ArrayList<>();
            for (Account acc : user.getAccounts()) {
                AccountResponse accountDetails = new AccountResponse();
                accountDetails.setId(acc.getId());
                accountDetails.setAccount_No(acc.getAccount_No());
                accountDetails.setIfsc_Code(acc.getIfsc_Code());
                accountDetails.setAccountType(acc.getAccountType().getAccountType());
                accountDetails.setBalance(acc.getBalance());
                accountDetails.setApproval(acc.isApproval());
                accountResponses.add(accountDetails);
            }
            userDetails.setAccounts(accountResponses);
            allUserDetailsResponse.add(userDetails);
        }
        return allUserDetailsResponse;
    }
}
