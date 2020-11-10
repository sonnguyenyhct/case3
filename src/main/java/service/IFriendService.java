package service;

import model.Friend;

import java.sql.SQLException;
import java.util.List;

public interface IFriendService {
    void makeFriend(int idFriend, int idUser) throws SQLException;
    List<Friend> displayAllFriend(int idUser) throws SQLException;
    List<Friend>displayListPending(int idUser) throws SQLException;
    void acceptFriend(int idFriend) throws SQLException;
    void setAcceptFriendSql(int idFriend, int idUser) throws SQLException;
}