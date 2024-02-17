package com.shantesh.springbootrestwebservice.user;

import com.shantesh.springbootrestwebservice.user.post.Post;

import java.util.Date;
import java.util.List;

//@ApiModel(description = "All details about the User")
public class User {
    private Integer id;
//    @Size(min = 2, message = "Size must be greater than 2 chars")
//    @ApiModelProperty(notes = "name should have at least 2 characters")
    private String name;
//    @Past
//    @ApiModelProperty(notes = "Birth date should be in the past")
    private Date birthDate;

    private List<Post>   posts;

    public User() {
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(Integer id, String name, Date birthDate, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }

}
