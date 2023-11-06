package ru.bmstu.icsnetwork.presentation.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;

@Service
public class IcsUserDetailsService implements UserDetailsService {

    private IUserRepository userRepository;

    public IcsUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return UserPrincipal.from(userRepository
                .findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username))));
    }

    @Transactional
    public UserDetails loadUserById(long id) {
        return UserPrincipal.from(userRepository
                .findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %d not found", id))));
    }
}
