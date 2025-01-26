package com.event.eventManagement.service;

import com.event.eventManagement.entity.User;

public interface UserService {

    User createUser(User u);
    User getUserById(Long id);
}
