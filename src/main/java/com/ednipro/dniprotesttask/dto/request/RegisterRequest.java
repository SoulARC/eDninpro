package com.ednipro.dniprotesttask.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
}
