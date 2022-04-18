package com.example.ksmapi.controller.user.impl;

import com.example.ksmapi.controller.user.UserAccountController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.factory.user.UserAccountFactory;
import com.example.ksmapi.service.user.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/user-account/")
public class UserAccountControllerImpl implements UserAccountController {
    private final UserAccountFactory factory;
    private final UserAccountService service;
    private final ResponseDeal responseDeal;

    public UserAccountControllerImpl(UserAccountFactory factory, UserAccountService service, ResponseDeal responseDeal) {
        this.factory = factory;
        this.service = service;
        this.responseDeal = responseDeal;
    }
    @PostMapping("create")
    @Override
    public ResponseEntity<UserAccount> save(@RequestParam UserAccount userAccount, HttpServletRequest request) {
        UserAccount userAccount1 = factory.getUserAccount(userAccount.getEmail(), userAccount.getOrganizationId(), userAccount.getRoleId(), userAccount.getPassword(), userAccount.getDate(), userAccount.isState(), userAccount.getDescription());
        UserAccount result = service.save(userAccount1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @Override
    public ResponseEntity<UserAccount> update(UserAccount userAccount, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<UserAccount> read(String id, HttpServletRequest request) {
        return null;
    }

    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads")
    @Override
    public ResponseEntity<List<UserAccount>> readAll(HttpServletRequest request) {
        List<UserAccount> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
