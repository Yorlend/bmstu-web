package ru.bmstu.icsnetwork.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentModel {
    private long id;
    private String content;
    private UserModel author;
}
