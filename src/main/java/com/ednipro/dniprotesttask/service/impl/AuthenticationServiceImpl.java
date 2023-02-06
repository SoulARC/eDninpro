package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.dto.request.AuthenticationRequest;
import com.ednipro.dniprotesttask.dto.request.AuthenticationResponse;
import com.ednipro.dniprotesttask.dto.request.RegisterRequest;
import com.ednipro.dniprotesttask.model.Role;
import com.ednipro.dniprotesttask.model.User;
import com.ednipro.dniprotesttask.repository.UserRepository;
import com.ednipro.dniprotesttask.security.JwtUtils;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Role DEFAULT_ROLE = Role.USER;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(DEFAULT_ROLE)
                .build();
        userRepository.save(user);
        var jwtToken = jwtUtils.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public boolean usernameAvailabilityCheck(String email) {
        return userRepository.existsByEmail(email);
    }
}
