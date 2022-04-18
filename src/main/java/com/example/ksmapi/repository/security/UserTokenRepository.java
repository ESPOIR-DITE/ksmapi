package com.example.ksmapi.repository.security;

import com.example.ksmapi.domain.security.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,String> {
}
