package com.example.ksmapi.service.Security;

import com.example.ksmapi.domain.security.ApiKey;
import com.example.ksmapi.service.ServiceInterface;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.lang.JoseException;

import java.util.Optional;

public interface ApiKeyService extends ServiceInterface<ApiKey,String> {
    Optional<ApiKey> findById(String id);
    void deleteById(String id);
    String generateJsonPublicKey() throws JoseException;
    PublicJsonWebKey getPublicJsonWebKey(ApiKey apiKey) throws JoseException;
}
