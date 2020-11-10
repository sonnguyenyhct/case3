package model;

public class Friend {
    int idFriend;
    String avatarFriend;
    String friendName;

    public Friend(String avatarFriend, String friendName) {
        this.avatarFriend = avatarFriend;
        this.friendName = friendName;
    }

    public Friend(int idFriend, String avatarFriend, String friendName) {
        this.idFriend = idFriend;
        this.avatarFriend = avatarFriend;
        this.friendName = friendName;
    }

    public int getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(int idFriend) {
        this.idFriend = idFriend;
    }

    public String getAvatarFriend() {
        return avatarFriend;
    }

    public void setAvatarFriend(String avatarFriend) {
        this.avatarFriend = avatarFriend;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}