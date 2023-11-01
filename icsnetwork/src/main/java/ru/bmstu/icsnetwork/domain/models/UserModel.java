package ru.bmstu.icsnetwork.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private long id;
    private String login;
    private String name;
    private String username;
}
