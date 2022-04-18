package com.example.ksmapi.service.Security.impl;

import com.example.ksmapi.domain.security.ApiKey;
import com.example.ksmapi.domain.security.UserToken;
import com.example.ksmapi.enums.GenericEnum;
import com.example.ksmapi.enums.KeyEnum;
import com.example.ksmapi.enums.SecurityEnum;
import com.example.ksmapi.service.Security.ApiKeyService;
import com.example.ksmapi.service.Security.TokenService;
import com.example.ksmapi.util.StringHelper;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    private final ApiKeyService apiKeyService;
    private final UserTokenServiceImpl userTokenService;

    @Autowired
    public TokenServiceImpl(ApiKeyService apiKeyService, UserTokenServiceImpl userTokenService) {
        this.apiKeyService = apiKeyService;
        this.userTokenService = userTokenService;
    }

    @Override
    public String generateToken(String userId, String role) throws Exception {
        final float TOKEN_VALIDITY_PERIOD = 180; // 3 hours
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setIssuer(SecurityEnum.ISSUER.VALUE);
        jwtClaims.setAudience(SecurityEnum.SITE_USERS.VALUE);
        jwtClaims.setExpirationTimeMinutesInTheFuture(TOKEN_VALIDITY_PERIOD);
        jwtClaims.setGeneratedJwtId();
        jwtClaims.setIssuedAtToNow();
        jwtClaims.setNotBeforeMinutesInThePast(2);
        jwtClaims.setSubject(SecurityEnum.SITE_ACCESS.VALUE);
        jwtClaims.setClaim(GenericEnum.EMAIL.VALUE, userId);
        jwtClaims.setClaim(SecurityEnum.AUTHORITIES.VALUE, role);
        return generateTokenFromClaims(jwtClaims);
    }
    private String generateTokenFromClaims(JwtClaims jwtClaims) throws Exception {
        PublicJsonWebKey publicJsonWebKey = getPublicJsonWebKey();
        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.setPayload(jwtClaims.toJson());
        jsonWebSignature.setKey(publicJsonWebKey.getPrivateKey());
        jsonWebSignature.setKeyIdHeaderValue(publicJsonWebKey.getKeyId());
        jsonWebSignature.setAlgorithmHeaderValue(AlgorithmIdentifiers.ECDSA_USING_P256_CURVE_AND_SHA256);
        return jsonWebSignature.getCompactSerialization();
    }
    private PublicJsonWebKey getPublicJsonWebKey() throws Exception {
        ApiKey publicKey = this.apiKeyService.findById(KeyEnum.PUBLIC_KEY.VALUE)
                .orElseThrow(() -> new Exception("No public key found!"));
        return this.apiKeyService.getPublicJsonWebKey(publicKey);
    }
    private String getStringClaimFromToken(String token, String claimType) throws Exception {
        JwtClaims jwtClaims = getJwtClaimsFromToken(token);
        return (String) jwtClaims.getClaimValue(claimType);
    }

    private JwtClaims getJwtClaimsFromToken(String token) throws Exception {
        PublicJsonWebKey publicJsonWebKey = getPublicJsonWebKey();
        JwtConsumer jwtConsumer = new JwtConsumerBuilder().setVerificationKey(publicJsonWebKey.getPublicKey())
                .setExpectedAudience(SecurityEnum.SITE_USERS.VALUE).build();
        JwtContext jwtContext = jwtConsumer.process(token);
        return jwtContext.getJwtClaims();
    }

    private NumericDate getTokenExpiration(String token) throws Exception {
        JwtClaims jwtClaims = getJwtClaimsFromToken(token);
        return jwtClaims.getExpirationTime();
    }

        @Override
    public boolean isTokenValid(String token) throws Exception {
            if (!StringHelper.isEmptyorNull(token)) {
                String userId = getUserIdFromToken(token);
                String roleId = getUserAuthoritiesFromToken(token);
//                this.userService.findById(userId)
//                        .orElseThrow(() -> new Exception("No user found!"));
                UserToken userToken = this.userTokenService.read(userId);
//                UserRole userRole = this.userRoleService.findById(userId)
//                        .orElseThrow(() -> new Exception("No user role found!"));
                NumericDate expiration = getTokenExpiration(token);
                return userToken.getToken().equalsIgnoreCase(token)
                        && expiration.isAfter(NumericDate.now());
//                        && userRole.getRoleId().equalsIgnoreCase(roleId);
            }
            return false;
    }

    @Override
    public String getUserIdFromToken(String token) throws Exception {
        return getStringClaimFromToken(token, GenericEnum.EMAIL.VALUE);
    }

    @Override
    public String getUserAuthoritiesFromToken(String token) throws Exception {
        return getStringClaimFromToken(token, SecurityEnum.AUTHORITIES.VALUE);
    }
}
