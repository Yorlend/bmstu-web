package ru.bmstu.icsnetwork.presentation.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import ru.bmstu.icsnetwork.presentation.requests.SignInRequest;

public final class AuthenticateUserInputMapper {
    public static AuthenticateUserUseCase.Input map(SignInRequest req) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                req.getUsername(),
                req.getPassword()
        );

        return new AuthenticateUserUseCase.Input(authentication);
    }
}
