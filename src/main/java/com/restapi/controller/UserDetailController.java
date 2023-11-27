package com.restapi.controller;

import com.restapi.model.UserDetail;
import com.restapi.request.AddressRequest;
import com.restapi.request.LoginRequest;
import com.restapi.request.UserDetailRequest;
import com.restapi.response.AddressResponse;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserDetailResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/showDetails")
public class UserDetailController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> UserDetail(@PathVariable Long id) {
        UserDetail userDetail = userDetailService.UserDetail(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userDetail);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<APIResponse> createAddress(@RequestBody UserDetailRequest userDetailRequest) {
        UserDetailResponse userDetailResponse = userDetailService.create(userDetailRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userDetailResponse.getUserDetail());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<APIResponse> updateAddress(@RequestBody UserDetailRequest userDetailRequest) {
        UserDetailResponse userDetailResponse = userDetailService.update(userDetailRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userDetailResponse.getUserDetail());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<APIResponse> deleteAddress(@PathVariable Long id) {
//        UserDetailResponse userDetailResponse = userDetailService
//                .deleteById(Long.valueOf(id));
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(userDetailResponse.getUserDetail());
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
}
