package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.RegisterResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthDto {

    public AppUser mapToAppUser(RegisterRequest user) {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setPassword(user.getPassword());
        return appUser;
    }

    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setRole(appUser.getRole().getName());
        return authResponse;
    }

}
