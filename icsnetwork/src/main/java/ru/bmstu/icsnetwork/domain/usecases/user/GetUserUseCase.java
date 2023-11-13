package ru.bmstu.icsnetwork.domain.usecases.user;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class GetUserUseCase extends UseCase<GetUserUseCase.Input, GetUserUseCase.Output> {

    private final IUserRepository userRepository;

    public GetUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output execute(Input input) {
        return new Output(
                userRepository.findById(input.id).orElseThrow()
        );
    }

    @Value
    public static class Input implements UseCase.Input {
        long id;
    }

    @Value
    public static class Output implements UseCase.Output {
        UserModel user;
    }
}
