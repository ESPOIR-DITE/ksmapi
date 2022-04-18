package com.example.ksmapi.config;

import com.example.ksmapi.service.Security.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final TokenServiceImpl tokenService;

    @Autowired
    public JWTAuthorizationFilter(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    private boolean hasAuthenticationHeader(HttpServletRequest httpServletRequest) {
        String authenticationHeader = httpServletRequest.getHeader(HEADER);
        return authenticationHeader != null && authenticationHeader.startsWith(PREFIX);
    }

    private void setUpSpringAuthentication(String userId, String claims) {
        List<String> authorities = Arrays.asList(claims.split(","));
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userId, null, simpleGrantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

        @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(hasAuthenticationHeader(request)){
            String token = request.getHeader(HEADER).replace(PREFIX, "");
            if (tokenService == null) SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, request.getServletContext());
            try{
                String email = this.tokenService.getUserIdFromToken(token);
                if (this.tokenService.isTokenValid(token)){
                    String claims = this.tokenService.getUserAuthoritiesFromToken(token);
                    setUpSpringAuthentication(email,claims);
                }else System.out.printf("Invalid token: %s, for userId: %s", token, email);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.print("No authentication header in request");
            filterChain.doFilter(request,response);
        }
    }
}
