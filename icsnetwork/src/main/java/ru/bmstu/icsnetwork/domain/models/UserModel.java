package ru.bmstu.icsnetwork.domain.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private long id;
    private String login;
    private String name;
    private String username;
    private String password;

    @Singular
    private List<PostModel> posts;

    @Singular
    private List<CommentModel> comments;

    @Singular
    private List<VoteModel> votes;
}
