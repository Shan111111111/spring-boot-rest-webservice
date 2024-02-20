package com.shantesh.springbootrestwebservice.user;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;


@ApiModel(description = "All details about user")
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer Id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private  User user;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                '}';
    }
}
