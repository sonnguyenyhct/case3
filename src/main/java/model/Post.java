package model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Post {
    int idPost;
    String avatar;
    String userName;
    LocalDateTime timePost;
    String image;
    String content;
    int likeCount;
    int idUser;

    public void setTimePost(LocalDateTime timePost) {
        this.timePost = timePost;
    }

    public Post() {
    }

    public Post(String image, String content, LocalDateTime timePost) {
        this.image = image;
        this.content = content;
        this.timePost = timePost;
    }

    public Post(int idPost,String avatar, String userName, LocalDateTime timePost, String image, String content, int likeCount, int idUser) {
        this.avatar = avatar;
        this.userName = userName;
        this.timePost = timePost;
        this.image = image;
        this.content = content;
        this.likeCount = likeCount;
        this.idUser = idUser;
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
        return this.timePost;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
