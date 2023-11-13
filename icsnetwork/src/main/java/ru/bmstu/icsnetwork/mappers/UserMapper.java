package ru.bmstu.icsnetwork.mappers;

import lombok.val;
import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.domain.models.UserModel;

public class UserMapper {
    public static UserEntity userEntityFromModel(UserModel userModel) {
        val user = UserEntity.builder()
                .id(userModel.getId())
                .login(userModel.getLogin())
                .name(userModel.getName())
                .password(userModel.getPassword())
                .build();

//        user.setComments(userModel.getComments().stream().map(CommentMapper::commentEntityFromModel).toList());
//        user.setPosts(userModel.getPosts().stream().map(PostMapper::postEntityFromModel).toList());
//        user.setVotes(userModel.getVotes().stream().map(VoteMapper::voteEntityFromModel).toList());

        return user;
    }

    public static UserModel userModelFromEntity(UserEntity userEntity) {
        val user = UserModel.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .build();

//        user.setComments(userEntity.getComments().stream().map(CommentMapper::commentModelFromEntity).toList());
//        user.setPosts(userEntity.getPosts().stream().map(PostMapper::postModelFromEntity).toList());
//        user.setVotes(userEntity.getVotes().stream().map(VoteMapper::voteModelFromEntity).toList());

        return user;
    }
}
