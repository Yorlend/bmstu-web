package ru.bmstu.icsnetwork.mappers;

import ru.bmstu.icsnetwork.data.entities.CommentEntity;
import ru.bmstu.icsnetwork.domain.models.CommentModel;

public class CommentMapper {
    public static CommentEntity commentEntityFromModel(CommentModel commentModel) {
        return CommentEntity.builder()
                .id(commentModel.getId())
                .content(commentModel.getContent())
                .author(UserMapper.userEntityFromModel(commentModel.getAuthor()))
                .post(PostMapper.postEntityFromModel(commentModel.getPost()))
                .build();
    }

    public static CommentModel commentModelFromEntity(CommentEntity commentEntity) {
        return CommentModel.builder()
                .id(commentEntity.getId())
                .content(commentEntity.getContent())
                .author(UserMapper.userModelFromEntity(commentEntity.getAuthor()))
                .post(PostMapper.postModelFromEntity(commentEntity.getPost()))
                .build();
    }
}
