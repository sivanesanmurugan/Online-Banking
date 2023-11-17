package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.model.UserDetail;
import com.restapi.request.UserDetailRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDetailDto {

    public UserDetail mapToUserDetail(UserDetailRequest userDetailRequest) {
        UserDetail userDetail = new UserDetail();
        if (userDetailRequest.getId() != null) {
            userDetail.setId(userDetailRequest.getId());
        }
        userDetail.setFirstName(userDetailRequest.getFirstname());
        userDetail.setLastName(userDetailRequest.getLastname());
        userDetail.setEmail(userDetailRequest.getEmail());
        userDetail.setPhone(userDetailRequest.getPhone());
        return userDetail;
    }


    public UserDetailResponse mapToUserDetailResponse(UserDetail userDetail) {
        return new UserDetailResponse(userDetail);
    }
}
