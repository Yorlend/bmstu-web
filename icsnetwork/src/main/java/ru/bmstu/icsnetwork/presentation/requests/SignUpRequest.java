package ru.bmstu.icsnetwork.presentation.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import ru.bmstu.icsnetwork.domain.usecases.user.AddUserUseCase;

@Value
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    String name;

    @NotBlank
    @Size(max = 20)
    String login;

    @NotBlank
    @Size(min = 6, max = 50)
    String password;

    public static AddUserUseCase.Input from(SignUpRequest request) {
        return new AddUserUseCase.Input(
                request.name,
                request.login,
                request.password
        );
    }
}
