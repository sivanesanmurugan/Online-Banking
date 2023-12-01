package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class RegisterRequest {

        private Long id;

        @NotEmpty(message = "First name cannot be empty")
        private String firstName;

        @NotEmpty(message = "Last name cannot be empty")
        private String lastName;

        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        private String email;

        @NotEmpty(message = "Phone cannot be empty")
        @Pattern(regexp = "\\d{10}", message = "Phone should be a 10-digit number")
        private String phone;

        @NotEmpty(message = "Address cannot be empty")
        private String address;

        @NotEmpty(message = "City cannot be empty")
        private String city;

        @NotEmpty(message = "State cannot be empty")
        private String state;

        @NotNull(message = "Zip code cannot be null")
        @Min(value = 100000, message = "Zip code should be a 6-digit number")
        @Max(value = 999999, message = "Zip code should be a 6-digit number")
        private Integer zipcode;

        @NotEmpty(message = "Username cannot be empty")
        @Size(min = 2, message = "Username should have at least 2 characters")
        private String username;

        @NotEmpty(message = "Password cannot be empty")
        @Size(min = 2, message = "Password should have at least 2 characters")
        private String password;

        @NotNull(message = "Account type ID cannot be null")
        private Long acc_type_id;
    }
