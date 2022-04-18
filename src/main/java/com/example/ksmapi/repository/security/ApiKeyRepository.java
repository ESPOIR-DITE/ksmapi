package com.example.ksmapi.repository.security;

import com.example.ksmapi.domain.security.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {
}
