package ru.bmstu.icsnetwork.presentation.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.bmstu.icsnetwork.presentation.requests.SignInRequest;
import ru.bmstu.icsnetwork.presentation.requests.SignUpRequest;
import ru.bmstu.icsnetwork.presentation.responses.ApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.AuthResponse;
import ru.bmstu.icsnetwork.presentation.responses.GetAllUsersApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.UserApiResponse;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public interface UserResource {

    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> registerUser(
            @Valid @RequestBody SignUpRequest request, HttpServletRequest httpServletRequest);

    @PostMapping("/login")
    CompletableFuture<ResponseEntity<AuthResponse>> loginUser(
            @Valid @RequestBody SignInRequest request
    );

    @GetMapping
    CompletableFuture<GetAllUsersApiResponse> getAllUsers();

    @GetMapping("/{id}")
    CompletableFuture<ResponseEntity<UserApiResponse>> getUser(@PathVariable("id") long id);
}
