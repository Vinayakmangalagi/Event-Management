package com.event.eventManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(Customizer.withDefaults())
                        .csrf(csrf->csrf.disable())
                                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                                        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
