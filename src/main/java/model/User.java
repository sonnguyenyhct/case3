package model;

public class User {
    private int idUser;
    private String name;
    private String userAccount;
    private String userPassword;
    private String avatarCover;
    private String avatar;

    public User() {
    }

    public User(String name, String userAccount, String userPassword, String avatarCover, String avatar) {
        this.name = name;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.avatarCover = avatarCover;
        this.avatar = avatar;
    }

    public User(int idUser, String name, String userAccount, String userPassword, String avatarCover, String avatar) {
        this.idUser = idUser;
        this.name = name;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.avatarCover = avatarCover;
        this.avatar = avatar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAvatarCover() {
        return avatarCover;
    }

    public void setAvatarCover(String avatarCover) {
        this.avatarCover = avatarCover;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
