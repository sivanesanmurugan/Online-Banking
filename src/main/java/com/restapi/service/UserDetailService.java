package com.restapi.service;

import com.restapi.dto.UserDetailDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.model.UserDetail;
import com.restapi.repository.RoleRepository;
import com.restapi.repository.UserDetailRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.RegisterRequest;
import com.restapi.request.UserDetailRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailDto userDetailDto;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRepository userRepository;

    public UserDetailResponse create(UserDetailRequest userDetailRequest) {
        UserDetail userDetail = userDetailDto.mapToUserDetail(userDetailRequest);
        System.out.println(userDetail.getState());
        AppUser appUser = userRepository.findById(userDetailRequest.getUser_Id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        userDetailRequest.getUser_Id()));
        userDetail.setAppUser(appUser);
        userDetailRepository.save(userDetail);
        return userDetailDto.mapToUserDetailResponse(userDetail);
    }

    public UserDetailResponse update(UserDetailRequest userDetailRequest) {
        UserDetail userDetail = userDetailDto.mapToUserDetail(userDetailRequest);
        AppUser appUser = userRepository.findById(userDetailRequest.getUser_Id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        userDetailRequest.getUser_Id()));
        userDetail.setAppUser(appUser);
        userDetailRepository.save(userDetail);
        return userDetailDto.mapToUserDetailResponse(userDetail);
    }

    public UserDetail UserDetail(Long id) {
        return userDetailRepository.findByUserId(id);
    }
}
