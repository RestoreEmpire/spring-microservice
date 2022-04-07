package com.restoreempire.auth.service;

import com.restoreempire.auth.entity.Role;
import com.restoreempire.auth.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    ResponseEntity<IndexResponse> home() {
        return ResponseEntity.ok().body(new IndexResponse("home"));
    }
    
    
    @PostMapping("/registration")
    ResponseEntity<RegistrationResponse> registration(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setRole(new Role("user"));
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        userService.register(user);
        return ResponseEntity.ok().body(new RegistrationResponse("User was registred successfuly"));
    }

    private record IndexResponse(String page) {
    }

    private record RegistrationResponse(String status) {
    }

    private record UserRequest(String username, String password) {
    }    
}
