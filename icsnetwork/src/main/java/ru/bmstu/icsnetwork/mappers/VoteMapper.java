package ru.bmstu.icsnetwork.mappers;

import ru.bmstu.icsnetwork.data.entities.VoteEntity;
import ru.bmstu.icsnetwork.domain.models.VoteModel;

public class VoteMapper {
    public static VoteEntity voteEntityFromModel(VoteModel voteModel) {
        return VoteEntity.builder()
                .id(voteModel.getId())
                .user(UserMapper.userEntityFromModel(voteModel.getUser()))
                .post(PostMapper.postEntityFromModel(voteModel.getPost()))
                .vote(voteModel.isVote())
                .build();
    }

    public static VoteModel voteModelFromEntity(VoteEntity voteEntity) {
        return VoteModel.builder()
                .id(voteEntity.getId())
                .user(UserMapper.userModelFromEntity(voteEntity.getUser()))
                .post(PostMapper.postModelFromEntity(voteEntity.getPost()))
                .vote(voteEntity.isVote())
                .build();
    }
}
