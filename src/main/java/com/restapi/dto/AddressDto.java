package com.restapi.dto;

import com.restapi.model.Address;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressDto {
    public AddressResponse mapToAddressResponse(Address address) {
        return new AddressResponse(address);
    }

    public Address mapToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        if (addressRequest.getId() != null) {
            address.setId(addressRequest.getId());
        }
        address.setAddress(addressRequest.getAddress());
        address.setCity(addressRequest.getCity());
        address.setZipcode(addressRequest.getZipcode());
        return address;
    }
}