package ru.bmstu.icsnetwork.domain.usecases.user;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class AddUserUseCase extends UseCase<AddUserUseCase.Input, AddUserUseCase.Output> {
    private final IUserRepository userRepository;

    public AddUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output execute(Input input) {
        if (userRepository.findByLogin(input.login).isPresent()) {
            throw new IllegalArgumentException("Login already exists");
        }
        return new Output(userRepository.persist(UserModel.builder()
            .login(input.login)
            .name(input.name)
            .password(input.password)
            .build()));
    }

    @Value
    public static class Input implements UseCase.Input {
        String login;
        String name;
        String password;
    }

    @Value
    public static class Output implements UseCase.Output {
        UserModel user;
    }
}
