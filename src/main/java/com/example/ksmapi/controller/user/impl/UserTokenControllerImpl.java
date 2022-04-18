package com.example.ksmapi.controller.user.impl;

import com.example.ksmapi.controller.user.UserTokenController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.security.UserToken;
import com.example.ksmapi.service.Security.impl.UserTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/user-token/")
public class UserTokenControllerImpl implements UserTokenController {

    private final UserTokenServiceImpl service;
    private final ResponseDeal responseDeal;

            @Autowired
    public UserTokenControllerImpl(UserTokenServiceImpl service, ResponseDeal responseDeal) {
        this.service = service;
        this.responseDeal = responseDeal;
    }

    @Override
    public ResponseEntity<UserToken> save(UserToken userToken, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<UserToken> update(UserToken userToken, HttpServletRequest request) {
        return null;
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<UserToken> read(@RequestParam("id") String id, HttpServletRequest request) {
        UserToken result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(String id, HttpServletRequest request) {
        return null;
    }
    @GetMapping("delete-all")
    public void deleteAll(){
                service.deleteAll();
    }

    @GetMapping("reads")
    @Override
    public ResponseEntity<List<UserToken>> readAll(HttpServletRequest request) {
        List<UserToken> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
