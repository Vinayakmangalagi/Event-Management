package com.event.eventManagement.security;

import com.event.eventManagement.entity.User;
import com.event.eventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));
       return org.springframework.security.core.userdetails.User.builder()
               .username(user.getEmail())
               .password(user.getPassword())
               .build();
    }
}
