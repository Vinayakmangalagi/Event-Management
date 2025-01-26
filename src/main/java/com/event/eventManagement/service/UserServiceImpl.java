package com.event.eventManagement.service;

import com.event.eventManagement.entity.User;
import com.event.eventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User u) {
        if(userRepository.existsByEmail(u.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        return userRepository.save(u);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }
}
