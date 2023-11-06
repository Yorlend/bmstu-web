package ru.bmstu.icsnetwork.presentation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ru.bmstu.icsnetwork.presentation.security.IcsUserDetailsService;
import ru.bmstu.icsnetwork.presentation.security.JwtAuthEntrypoint;
import ru.bmstu.icsnetwork.presentation.security.JwtAuthFilter;
import ru.bmstu.icsnetwork.presentation.security.JwtProvider;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class Security {

    @Autowired
    private IcsUserDetailsService userDetailsService;

    @Autowired
    private JwtAuthEntrypoint unauthorizedHandler;

    @Autowired
    private JwtProvider jwtProvider;
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtProvider, userDetailsService);
    }

    // TODO: rewrite to Spring 6?
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
            .csrf(csrf -> csrf.disable())
            .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
            .headers(headers -> headers.frameOptions(frameOps -> frameOps.sameOrigin()))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST).authenticated()
                .anyRequest().permitAll()
            )
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
