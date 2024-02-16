package com.shantesh.springbootrestwebservice.user.post;

import com.shantesh.springbootrestwebservice.user.User;
import com.shantesh.springbootrestwebservice.user.UserDaoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersPostsDaoService {


    private static int incrementalId = 0;
    private static List<Post> posts;

    static {


        for (User user: UserDaoService.users){
            posts = new ArrayList<>();
            posts.add(new Post(incrementalId++, "started Learning this course of webservices at a great level"));
            posts.add(new Post(incrementalId++, "kehhooooo"));
            user.setPosts(posts);
        }

    }

    public List<Post> findAllPosts() {
//        return posts;
        for (User user: UserDaoService.users) {
            return new ArrayList<Post>(user.getPosts());

        }
		return null;
    }



    public Post savePost(Post post) {

        if (post.getId() == 0) {
            post.setId((post.getId()+1));
        }
        posts.add(post);
        return post;
    }

    public Post findOne(int id) {

        for (User user: UserDaoService.users) {
            for (Post post:user.getPosts()){
                if (post.getId() == id) {
                return post;
            }
            }
        }
        return null;
    }
}
