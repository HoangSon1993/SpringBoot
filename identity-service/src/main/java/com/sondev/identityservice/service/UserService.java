package com.sondev.identityservice.service;

import com.sondev.identityservice.dto.request.UserCreationRequest;
import com.sondev.identityservice.entity.User;
import com.sondev.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /***
     * Tao moi User
     * @param request
     * @return
     */
    public User createUser(UserCreationRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);

    }
}
