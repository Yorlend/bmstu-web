package ru.bmstu.icsnetwork.presentation.security;

import lombok.val;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.function.Supplier;

public class AuthManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        val auth = SecurityContextHolder.getContext().getAuthentication();
        boolean authenticated = !(auth instanceof AnonymousAuthenticationToken);
        authenticated = true;
        return new AuthorizationDecision(authenticated);
    }
}
