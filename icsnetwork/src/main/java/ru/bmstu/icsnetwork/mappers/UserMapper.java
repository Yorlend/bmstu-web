package ru.bmstu.icsnetwork.mappers;

import ru.bmstu.icsnetwork.presentation.dto.UserDTO;
import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.domain.models.UserModel;

public class UserMapper {
    public static UserEntity userEntityFromModel(UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .login(userModel.getLogin())
                .name(userModel.getName())
                .username(userModel.getUsername())
                .build();
    }

    public static UserModel userModelFromEntity(UserEntity userEntity) {
        return UserModel.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .name(userEntity.getName())
                .username(userEntity.getUsername())
                .build();
    }

    public static UserDTO userDTOFromModel(UserModel userModel) {
        return UserDTO.builder()
                .id(userModel.getId())
                .login(userModel.getLogin())
                .name(userModel.getName())
                .username(userModel.getUsername())
                .build();
    }

    public  static UserModel userModelFromDTO(UserDTO userDTO) {
        return UserModel.builder()
                .id(userDTO.getId())
                .login(userDTO.getLogin())
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .build();
    }
}
