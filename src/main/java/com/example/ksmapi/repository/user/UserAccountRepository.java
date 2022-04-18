package com.example.ksmapi.repository.user;

import com.example.ksmapi.domain.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
    UserAccount readByEmailAndPassword(String email,String password);
    UserAccount readByEmail(String email);
}
