package ru.bmstu.icsnetwork.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;
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
}
