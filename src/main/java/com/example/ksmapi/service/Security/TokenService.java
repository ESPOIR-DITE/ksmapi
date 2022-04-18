package com.example.ksmapi.service.Security;

public interface TokenService {
    String generateToken(String userId, String role) throws Exception;
    boolean isTokenValid(String token) throws Exception;
    String getUserIdFromToken(String token) throws Exception;
    String getUserAuthoritiesFromToken(String token) throws Exception;
}
