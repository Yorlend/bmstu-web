package ru.bmstu.icsnetwork.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModel {
    private long id;
    private String content;
    private String title;
    private UserModel author;
    private List<String> tags;
    private List<VoteModel> votes;
}
