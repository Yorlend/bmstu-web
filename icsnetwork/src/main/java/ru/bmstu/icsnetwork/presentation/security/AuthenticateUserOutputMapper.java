package ru.bmstu.icsnetwork.presentation.security;

import org.springframework.http.ResponseEntity;

import ru.bmstu.icsnetwork.presentation.responses.AuthResponse;

public class AuthenticateUserOutputMapper {
    public static ResponseEntity<AuthResponse> map(AuthenticateUserUseCase.Output out) {
        return ResponseEntity.ok(new AuthResponse(out.getJwtToken()));
    }
}
