package ru.bmstu.icsnetwork.presentation.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.bmstu.icsnetwork.domain.usecases.user.AddUserUseCase;
import ru.bmstu.icsnetwork.presentation.UseCaseExecutor;
import ru.bmstu.icsnetwork.presentation.requests.SignUpRequest;
import ru.bmstu.icsnetwork.presentation.responses.ApiResponse;

import java.util.concurrent.CompletableFuture;

@Service
public class UserController implements UserResource {
    private final UseCaseExecutor useCaseExecutor;
    private final AddUserUseCase addUserUseCase;
    private final AddUserInputMapper addUserInputMapper;

    public UserController(UseCaseExecutor useCaseExecutor,
                          AddUserUseCase addUserUseCase,
                          AddUserInputMapper addUserInputMapper) {
        this.useCaseExecutor = useCaseExecutor;
        this.addUserUseCase = addUserUseCase;
        this.addUserInputMapper = addUserInputMapper;
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> registerUser(SignUpRequest request, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
                addUserUseCase,
                addUserInputMapper.map(request),
                (output) -> AddUserOutputMapper.map(output.getUser(), httpServletRequest));
    }
}
