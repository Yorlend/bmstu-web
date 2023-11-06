package ru.bmstu.icsnetwork.presentation.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class AuthenticateUserUseCase extends UseCase<AuthenticateUserUseCase.Input, AuthenticateUserUseCase.Output> {

    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;

    public AuthenticateUserUseCase(
            AuthenticationManager authenticationManager,
            JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Output execute(Input input) {
        return new Output(
                jwtProvider.generateToken(
                        authenticationManager.authenticate(input.getAuthentication())
                )
        );
    }

    @Value
    public static class Input implements UseCase.Input {
        UsernamePasswordAuthenticationToken authentication;
    }

    @Value
    public static class Output implements UseCase.Output {
        String jwtToken;
    }
}
