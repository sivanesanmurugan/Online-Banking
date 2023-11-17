package com.restapi.request;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressRequest {
    private Long id;
    private String address;
    private String city;
    private Integer zipcode;
    private Long user_id;
}
