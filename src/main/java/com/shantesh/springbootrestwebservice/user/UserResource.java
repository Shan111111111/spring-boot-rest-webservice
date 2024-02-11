package com.shantesh.springbootrestwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")
    public User retrieveAllUsers(@PathVariable int id){
        return userDaoService.findOne(id);
    }

    //CREATED
    //input --details of user
    //output --CREATED & Return th created URI

    @PostMapping("/users")
    public void retrieveAllUsers(@RequestBody User user){
         userDaoService.saveUser(user);
    }

}
