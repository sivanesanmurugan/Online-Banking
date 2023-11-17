package com.restapi.service;

import com.restapi.dto.AddressDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Address;
import com.restapi.model.AppUser;
import com.restapi.repository.AddressRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressDto addressDto;

    @Transactional
    public AddressResponse create(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        addressRequest.getUser_id()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return addressDto.mapToAddressResponse(address);
    }

    public AddressResponse update(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        addressRequest.getUser_id()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return addressDto.mapToAddressResponse(address);
    }


}