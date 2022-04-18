package com.example.ksmapi.controller.user.impl;

import com.example.ksmapi.controller.user.UserController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.user.Users;
import com.example.ksmapi.factory.user.UserFactory;
import com.example.ksmapi.service.user.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/user/")
public class UserControllerImpl implements UserController {
    private final UserServiceImpl service;
    private final UserFactory factory;
    private final ResponseDeal responseDeal;

    public UserControllerImpl(UserServiceImpl service, UserFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<Users> save(@RequestBody Users users, HttpServletRequest request) {
       //User userObject = factory.getUser(user.getEmail(),user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getOrganisationId(),user.getRoleId());
       Users result = service.save(users);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<Users> update(@RequestBody Users users, HttpServletRequest request) {
        Users result = service.save(users);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<Users> read(@RequestParam("id") String id, HttpServletRequest request) {
        Users result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads")
    @Override
    public ResponseEntity<List<Users>> readAll(HttpServletRequest request) {
        List<Users> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
