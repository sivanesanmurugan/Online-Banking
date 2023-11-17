package com.restapi.response;

import com.restapi.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class AddressResponse {
    private Address address;
}