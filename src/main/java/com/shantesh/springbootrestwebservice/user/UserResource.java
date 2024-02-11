package com.shantesh.springbootrestwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    //GEt /users

    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //retrieveUser(int id)


}
