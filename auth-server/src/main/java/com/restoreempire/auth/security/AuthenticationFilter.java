package com.restoreempire.auth.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = obtainUsername(request);
        username = (username != null) ? username : "";
		username = username.trim();
		String password = obtainPassword(request);
		password = (password != null) ? password : "";
        UsernamePasswordAuthenticationToken authToken = 
        new UsernamePasswordAuthenticationToken(
            username, password);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        UserDetails authenticatedUser = (UserDetails) authResult.getPrincipal();
        String token = JWT.create()
            .withSubject(authenticatedUser.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + 1800000L))
            .withClaim("roles", authenticatedUser.getAuthorities()
                .stream()
                .map(
                    (t) -> t.getAuthority())
                        .collect(Collectors.toList()))
            .sign(Algorithm.HMAC256("fake-secret"));
        response.setContentType("application/json");
        Map<String,String> jsonToken = Collections.singletonMap("access_token", token);
        new ObjectMapper().writeValue(response.getOutputStream(), jsonToken);
    }

}
