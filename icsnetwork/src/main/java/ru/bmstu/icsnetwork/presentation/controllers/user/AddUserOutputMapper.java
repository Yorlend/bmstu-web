package ru.bmstu.icsnetwork.presentation.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.presentation.responses.ApiResponse;

import java.net.URI;

public class AddUserOutputMapper {
    public static ResponseEntity<ApiResponse> map(UserModel user, HttpServletRequest httpServletRequest) {
        URI location = ServletUriComponentsBuilder
                .fromContextPath(httpServletRequest)
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "registration successful"));
    }
}
