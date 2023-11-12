package ru.bmstu.icsnetwork.presentation.security;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "login", "name", "password"})
public class UserPrincipal implements UserDetails {

    private long id;
    private String login;
    private String name;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal from(UserModel userModel) {
        return UserPrincipal.builder()
                .id(userModel.getId())
                .login(userModel.getLogin())
                .name(userModel.getName())
                .password(userModel.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
    }

    public UserModel toUserModel() {
        return UserModel.builder()
                .id(id)
                .login(login)
                .name(name)
                .password(password)
                .build();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
