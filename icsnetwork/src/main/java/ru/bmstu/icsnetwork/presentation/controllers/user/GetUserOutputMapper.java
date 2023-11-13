package ru.bmstu.icsnetwork.presentation.controllers.user;

import org.springframework.http.ResponseEntity;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.presentation.responses.UserApiResponse;

public class GetUserOutputMapper {

    public static ResponseEntity<UserApiResponse> map(UserModel user) {
        return ResponseEntity.ok(UserApiResponse.from(user));
    }
}
