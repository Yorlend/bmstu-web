package ru.bmstu.icsnetwork.presentation;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.bmstu.icsnetwork.data.repositories.UserRepository;

@SpringBootApplication(scanBasePackages = {
        "ru.bmstu.icsnetwork.presentation", "ru.bmstu.icsnetwork.data.repositories"})
public class IcsnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcsnetworkApplication.class, args);
    }

    @Bean
    public ApplicationRunner configure(UserRepository userRepository) {
        return env ->
        {

        };
    }
}
