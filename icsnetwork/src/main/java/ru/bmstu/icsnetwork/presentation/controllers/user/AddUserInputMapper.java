package ru.bmstu.icsnetwork.presentation.controllers.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.bmstu.icsnetwork.domain.usecases.user.AddUserUseCase;
import ru.bmstu.icsnetwork.presentation.requests.SignUpRequest;

public class AddUserInputMapper {
    private PasswordEncoder passwordEncoder;

    public AddUserInputMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AddUserUseCase.Input map(SignUpRequest request) {
        return new AddUserUseCase.Input(
                request.getName(),
                request.getLogin(),
                passwordEncoder.encode(request.getPassword())
        );
    }
}
