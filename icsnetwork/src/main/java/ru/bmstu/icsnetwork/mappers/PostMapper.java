package ru.bmstu.icsnetwork.mappers;

import lombok.val;
import ru.bmstu.icsnetwork.data.entities.PostEntity;
import ru.bmstu.icsnetwork.domain.models.PostModel;

public class PostMapper {
    public static PostEntity postEntityFromModel(PostModel postModel) {
        val post = PostEntity.builder()
                .id(postModel.getId())
                .content(postModel.getContent())
                .title(postModel.getTitle())
                .author(UserMapper.userEntityFromModel(postModel.getAuthor()))
                .build();

//        post.setVotes(postModel.getVotes().stream().map(VoteMapper::voteEntityFromModel).toList());
        return post;
    }
    
    public static PostModel postModelFromEntity(PostEntity postEntity) {
        val post = PostModel.builder()
                .id(postEntity.getId())
                .content(postEntity.getContent())
                .title(postEntity.getTitle())
                .author(UserMapper.userModelFromEntity(postEntity.getAuthor()))
                .build();

//        post.setVotes(postEntity.getVotes().stream().map(VoteMapper::voteModelFromEntity).toList());
        return post;
    }
}
