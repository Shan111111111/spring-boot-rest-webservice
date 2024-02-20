package com.shantesh.springbootrestwebservice.user;

import com.shantesh.springbootrestwebservice.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    //GEt /users

    //retrieveAllUsers
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    //retrieveUser(int id)

    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()){
            throw new UserNotFoundException("id -" + id);
        }
        //"all-users", SERVER_PATH + "/users"
        // retrieveAllUsers
        Resource<User> resource = new Resource<User>(optionalUser.get());
        ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;

    }

    //CREATED
    //input --details of user
    //output --CREATED & Return th created URI

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> retrieveAllUsers(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);


    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsersPosts(@PathVariable int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new UserNotFoundException("id-"+ id);
        }
        return optionalUser.get().getPostList();
    }



    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> retrieveAllUsers(@PathVariable int id, @RequestBody Post post){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new UserNotFoundException("id-"+ id);
        }

        User user = optionalUser.get();
        post.setUser(user);
        postRepository.save(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
