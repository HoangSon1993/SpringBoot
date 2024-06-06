package com.sondev.identityservice.controller;

import com.sondev.identityservice.dto.request.UserCreationRequest;
import com.sondev.identityservice.entity.User;
import com.sondev.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationRequest request){
      return userService.createUser(request);
    }
}
