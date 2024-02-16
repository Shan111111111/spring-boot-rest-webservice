package com.shantesh.springbootrestwebservice.user.post;

public class Post {

    private int id;
    private String comment;

    public Post(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
