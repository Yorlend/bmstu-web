package ru.bmstu.icsnetwork.domain.usecases.user;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

import java.util.List;

public class GetAllUsersUseCase extends UseCase<GetAllUsersUseCase.Input, GetAllUsersUseCase.Output> {

    private IUserRepository userRepository;

    public GetAllUsersUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output execute(Input input) {
        return new Output(
                userRepository.findAll()
        );
    }

    public static class Input implements UseCase.Input {}

    @Value
    public static class Output implements UseCase.Output {
        List<UserModel> users;
    }
}
