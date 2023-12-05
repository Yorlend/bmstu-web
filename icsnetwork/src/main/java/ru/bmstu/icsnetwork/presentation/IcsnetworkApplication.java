package ru.bmstu.icsnetwork.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;

@SpringBootApplication(scanBasePackages = {
        "ru.bmstu.icsnetwork.presentation", "ru.bmstu.icsnetwork.data.repositories"})
public class IcsnetworkApplication {

    @Autowired
    private PasswordEncoder pe;

    public static void main(String[] args) {
        SpringApplication.run(IcsnetworkApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(IUserRepository userRepository) {
        return env -> {
            try {
                userRepository.persist(
                    UserModel.builder()
                        .id(1)
                        .login("admin")
                        .name("Admin")
                        .password(pe.encode("admin"))
                        .build()
                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
