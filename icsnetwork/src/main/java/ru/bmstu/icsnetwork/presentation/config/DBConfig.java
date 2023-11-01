package ru.bmstu.icsnetwork.presentation.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "ru.bmstu.icsnetwork.data.entities")
@EnableJpaRepositories(basePackages = "ru.bmstu.icsnetwork.data.repositories")
public class DBConfig { }
