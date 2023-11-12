package ru.bmstu.icsnetwork.presentation.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.bmstu.icsnetwork.domain.usecases.user.AddUserUseCase;
import ru.bmstu.icsnetwork.presentation.UseCaseExecutor;
import ru.bmstu.icsnetwork.presentation.requests.SignInRequest;
import ru.bmstu.icsnetwork.presentation.requests.SignUpRequest;
import ru.bmstu.icsnetwork.presentation.responses.ApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.AuthResponse;
import ru.bmstu.icsnetwork.presentation.security.AuthenticateUserInputMapper;
import ru.bmstu.icsnetwork.presentation.security.AuthenticateUserOutputMapper;
import ru.bmstu.icsnetwork.presentation.security.AuthenticateUserUseCase;

import java.util.concurrent.CompletableFuture;

@Service
public class UserController implements UserResource {
    private final UseCaseExecutor useCaseExecutor;
    private final AddUserUseCase addUserUseCase;
    private final AddUserInputMapper addUserInputMapper;
    private final AuthenticateUserUseCase authenticateUserUseCase;

    public UserController(UseCaseExecutor useCaseExecutor,
                          AddUserUseCase addUserUseCase,
                          AddUserInputMapper addUserInputMapper,
                          AuthenticateUserUseCase authenticateUserUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.addUserUseCase = addUserUseCase;
        this.addUserInputMapper = addUserInputMapper;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> registerUser(SignUpRequest request, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
                addUserUseCase,
                addUserInputMapper.map(request),
                (output) -> AddUserOutputMapper.map(output.getUser(), httpServletRequest));
    }

    @Override
    public CompletableFuture<ResponseEntity<AuthResponse>> loginUser(SignInRequest request) {
        return useCaseExecutor.execute(
            authenticateUserUseCase,
            AuthenticateUserInputMapper.map(request),
            (output) -> AuthenticateUserOutputMapper.map(output)
        );
    }
}
