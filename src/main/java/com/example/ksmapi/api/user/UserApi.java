package com.example.ksmapi.api.user;

import com.example.ksmapi.domain.security.UserToken;
import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.domain.user.UserDetails;
import com.example.ksmapi.factory.user.UserAccountFactory;
import com.example.ksmapi.service.Security.UserTokenService;
import com.example.ksmapi.service.Security.impl.PasswordServiceImpl;
import com.example.ksmapi.service.Security.impl.TokenServiceImpl;
import com.example.ksmapi.service.user.UserAccountService;
import com.example.ksmapi.service.user.UserService;
import com.example.ksmapi.service.user.impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserApi {
    private final UserService userService;
    private final UserAccountServiceImpl userAccountService;
    private final UserAccountFactory userAccountFactory;
    private final UserTokenService userTokenService;
    private final PasswordServiceImpl passwordService;
    private final TokenServiceImpl tokenService;

    @Autowired
    public UserApi(UserService userService, UserAccountServiceImpl userAccountService, UserAccountFactory userAccountFactory, UserTokenService userTokenService, PasswordServiceImpl passwordService, TokenServiceImpl tokenService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.userAccountFactory = userAccountFactory;
        this.userTokenService = userTokenService;
        this.passwordService = passwordService;
        this.tokenService = tokenService;
    }

    public boolean register(UserDetails userDetails){
        UserAccount userAccount = userAccountFactory.getUserAccount(userDetails.getUserAccount().getEmail(),
                userDetails.getUserAccount().getEmail(),
                userDetails.getUserAccount().getRoleId(),
                userDetails.getUserAccount().getPassword(),
                userDetails.getUserAccount().getDate(),
                userDetails.getUserAccount().isState(),
                userDetails.getUserAccount().getDescription()
                );
        if(userAccountService.save(userAccount)!=null){
            if(userService.save(userDetails.getUsers())!=null) return true;
        }return false;
    }
    public UserToken login(String email, String password){
        UserAccount userAccount = userAccountService.readByEmailA(email);
        boolean isSame = passwordService.isPasswordMatch(password,userAccount.getPassword());
        if(isSame){
            // should check Role.
            try{
                String token = this.tokenService.generateToken(email,userAccount.getRoleId());
                UserToken userToken = UserToken.builder().token(token).email(email).build();
                return userTokenService.save(userToken);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } return null;
    }
    public void logout(String email){
        userTokenService.delete(email);
    }
}
