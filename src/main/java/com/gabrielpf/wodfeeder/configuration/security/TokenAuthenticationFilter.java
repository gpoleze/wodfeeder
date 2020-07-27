package com.gabrielpf.wodfeeder.configuration.security;

import static com.gabrielpf.wodfeeder.vo.AuthenticationTokenType.BEARER;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenAuthenticationService tokenService;

    public TokenAuthenticationFilter(TokenAuthenticationService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final var token = getToken(request);
        if (token.isPresent() && tokenService.isTokenValid(token.get()))
            authenticateClient(token.get());

        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        final var userDetails = tokenService.getUserPrincipal(token);
        final var authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Optional<String> getToken(HttpServletRequest request) {
        final var authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || authorizationHeader.isBlank() || !authorizationHeader.startsWith(BEARER))
            return Optional.empty();

        return Optional.of(authorizationHeader.replaceFirst(BEARER, "").trim());
    }
}
