package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;

@Value
public class AuthResponse {
    boolean success = true;
    String token;
}
