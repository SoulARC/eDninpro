package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.dto.request.AuthenticationRequest;
import com.ednipro.dniprotesttask.dto.request.AuthenticationResponse;
import com.ednipro.dniprotesttask.dto.request.RegisterRequest;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @GetMapping("/index")
    public String home() {
        return "index";
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model){
        RegisterRequest user = new RegisterRequest();
        model.addAttribute("user", user);
        return "register";
    }
    //Frontend doesn't work with the JWT token :(
    @PostMapping("/register/save")
    public ResponseEntity<AuthenticationResponse> register(
           RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login
            (AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
