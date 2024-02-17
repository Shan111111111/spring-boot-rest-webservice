package com.shantesh.springbootrestwebservice.user.post;

import com.shantesh.springbootrestwebservice.user.User;
import com.shantesh.springbootrestwebservice.user.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UsersPostsResource {
    @Autowired
    private UsersPostsDaoService usersPostsDaoService;

    //GEt /users

    //retrieveAllUsers
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts(){
        return usersPostsDaoService.findAllPosts();
    }

    //retrieveUser(int id)

    @GetMapping("/users/{id}/posts/{pid}")
    public Post retrieveAllUsers(@PathVariable(name = "pid") int pid){
        Post post = usersPostsDaoService.findOne(pid);

        if (post == null){
            throw new PostNotFoundException("id -" + pid);
        }
        return post;

    }

    //CREATED
    //input --details of user
    //output --CREATED & Return th created URI

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> retrieveAllUsers(@RequestBody Post post){
         Post  savedPost = usersPostsDaoService.savePost(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
