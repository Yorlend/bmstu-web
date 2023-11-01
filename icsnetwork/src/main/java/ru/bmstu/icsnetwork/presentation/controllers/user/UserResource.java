package ru.bmstu.icsnetwork.presentation.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.icsnetwork.presentation.requests.SignUpRequest;
import ru.bmstu.icsnetwork.presentation.responses.ApiResponse;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public interface UserResource {

    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> registerUser(
            @Valid @RequestBody SignUpRequest request, HttpServletRequest httpServletRequest);
}
