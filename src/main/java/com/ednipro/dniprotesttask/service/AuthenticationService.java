package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.dto.request.AuthenticationRequest;
import com.ednipro.dniprotesttask.dto.request.AuthenticationResponse;
import com.ednipro.dniprotesttask.dto.request.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    boolean usernameAvailabilityCheck(String login);
}
