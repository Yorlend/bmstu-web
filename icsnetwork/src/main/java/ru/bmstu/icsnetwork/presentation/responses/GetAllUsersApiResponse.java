package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.List;

@Value
public class GetAllUsersApiResponse {

    List<UserApiResponse> users;

    public static GetAllUsersApiResponse from(List<UserModel> users) {
        return new GetAllUsersApiResponse(
            users.stream()
                .map(UserApiResponse::from)
                .toList()
        );
    }
}
