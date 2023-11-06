package ru.bmstu.icsnetwork.presentation.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SignInRequest {
    
    @NotBlank
    String username;

    @NotBlank
    @Size(min = 6, max = 50)
    String password;
}
