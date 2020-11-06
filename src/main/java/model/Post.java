package model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Post {
    int idPost;
    String image;
    String content;

    public void setTimePost(LocalDateTime timePost) {
        this.timePost = timePost;
    }

    LocalDateTime timePost;

    public Post() {
    }

    public Post(int idPost, String image, String content, LocalDateTime timePost) {
        this.idPost = idPost;
        this.image = image;
        this.content = content;
        this.timePost = timePost;
    }

    public Post(String image, String content, LocalDateTime timePost) {
        this.image = image;
        this.content = content;
        this.timePost = timePost;
    }

    public Post(int idPost, String image, String content) {
        this.idPost = idPost;
        this.image = image;
        this.content = content;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimePost() {
        return LocalDateTime.now();
    }

}
