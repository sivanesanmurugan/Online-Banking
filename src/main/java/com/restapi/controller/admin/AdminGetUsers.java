package com.restapi.controller.admin;

import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.response.RegisterResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RolesAllowed(Role.ADMIN)
public class AdminGetUsers {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<APIResponse> getAllUsers() {
        List<AppUser> appUsers = userService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUsers);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
