package ru.bmstu.icsnetwork.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;
import ru.bmstu.icsnetwork.domain.usecases.post.*;
import ru.bmstu.icsnetwork.domain.usecases.user.AddUserUseCase;
import ru.bmstu.icsnetwork.presentation.controllers.user.AddUserInputMapper;

@Configuration
public class Module {

    @Bean
    public AddUserUseCase addUserUseCase(IUserRepository userRepository) {
        return new AddUserUseCase(userRepository);
    }

    @Bean
    public AddUserInputMapper addUserInputMapper(PasswordEncoder passwordEncoder) {
        return new AddUserInputMapper(passwordEncoder);
    }

    @Bean
    public AddPostUseCase addPostUseCase(IPostRepository postRepository) {
        return new AddPostUseCase(postRepository);
    }

    @Bean
    public GetAllPostsUseCase getAllPostsUseCase(IPostRepository postRepository) {
        return new GetAllPostsUseCase(postRepository);
    }

    @Bean
    public GetPostUseCase getPostUseCase(IPostRepository postRepository) {
        return new GetPostUseCase(postRepository);
    }

    @Bean
    public PatchPostUseCase patchPostUseCase(IPostRepository postRepository) {
        return new PatchPostUseCase(postRepository);
    }

    @Bean
    public AddCommentUseCase addCommentUseCase(IPostRepository postRepository) {
        return new AddCommentUseCase(postRepository);
    }

    @Bean
    public GetAllCommentsUseCase getAllCommentsUseCase(IPostRepository postRepository) {
        return new GetAllCommentsUseCase(postRepository);
    }
}
