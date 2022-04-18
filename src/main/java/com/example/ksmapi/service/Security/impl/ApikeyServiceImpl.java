package com.example.ksmapi.service.Security.impl;

import com.example.ksmapi.domain.security.ApiKey;
import com.example.ksmapi.enums.SecurityEnum;
import com.example.ksmapi.repository.security.ApiKeyRepository;
import com.example.ksmapi.service.Security.ApiKeyService;
import org.jose4j.jwk.EcJwkGenerator;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApikeyServiceImpl implements ApiKeyService {
    private final ApiKeyRepository repository;

    @Autowired
    public ApikeyServiceImpl(ApiKeyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ApiKey> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public String generateJsonPublicKey() throws JoseException {
        EllipticCurveJsonWebKey ellipticCurveJsonWebKey = EcJwkGenerator.generateJwk(EllipticCurves.P256);
        ellipticCurveJsonWebKey.setKeyId(SecurityEnum.PUBLIC_PHRASE.VALUE);
        return ellipticCurveJsonWebKey.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
    }

    @Override
    public PublicJsonWebKey getPublicJsonWebKey(ApiKey apiKey) throws JoseException {
        return PublicJsonWebKey.Factory.newPublicJwk(apiKey.getValue());
    }

    @Override
    public ApiKey save(ApiKey apiKey) {
        return repository.save(apiKey);
    }

    @Override
    public ApiKey read(String id) {
         Optional<ApiKey> apiKeyOptional = repository.findById(id);
         return apiKeyOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        ApiKey result = read(id);
        if(result!=null){
            repository.delete(result);
            return true;
        }return false;
    }

    @Override
    public List<ApiKey> readAll() {
        return repository.findAll();
    }
}
