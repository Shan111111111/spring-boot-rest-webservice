package com.shantesh.springbootrestwebservice.user;

import com.shantesh.springbootrestwebservice.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);

        if (user == null){
            throw new UserNotFoundException("id -" + id);
        }
        //"all-users", SERVER_PATH + "/users"
        // retrieveAllUsers
      /*  Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));*/

        return user;

    }

    //CREATED
    //input --details of user
    //output --CREATED & Return th created URI

    @PostMapping("/users")
    public ResponseEntity<Object> retrieveAllUsers(@RequestBody User user){
         User savedUser = userDaoService.saveUser(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteOne(id);

        if (user == null){
            throw new UserNotFoundException("id -" + id);
        }

    }
}
