package com.restapi.controller;

import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping()
    public ResponseEntity<APIResponse> createAddress(@RequestBody
                                                     AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.create(addressRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addressResponse.getAddress());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<APIResponse> updateAddress(@RequestBody
                                                     AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.update(addressRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addressResponse.getAddress());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}