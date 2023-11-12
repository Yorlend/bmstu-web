package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.UserModel;

@Value
public class UserApiResponse {
    long id;
    String name;
    String login;

    public static UserApiResponse from(UserModel user) {
        return new UserApiResponse(
            user.getId(),
            user.getName(),
            user.getLogin()
        );
    }
}
