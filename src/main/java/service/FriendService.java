package service;

import controller.AppUtils;
import model.Friend;

import javax.sound.midi.MidiDeviceReceiver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendService implements IFriendService {
    Connection connection = ConnectionDB.getConnection();
    private static final String MAKE_FRIEND_SQL = "INSERT INTO FRIEND VALUES(?,?,0)"; //?1 là id của friend, ?2 là id của session
    private static final String SELECT_ALLFRIEND_SQL = "SELECT u.avatar avatar, u.name name FROM friend f JOIN user u ON f.idSender=u.idUser WHERE status = 1 and idReceiver =?";
    private static final String ACCEPT_FRIEND_SQL = "UPDATE FRIEND\n" +
            "SET status = 1 where idSender = ? and status = 0;" ;
    private static final String ACCEPT_FRIEND_SQL2= "INSERT INTO FRIEND VALUES (?,?,1)";
    private static final String SELECT_FRIEND_PENDING_SQL = "SELECT u.idUser idUser, u.avatar avatar, u.name name FROM friend f JOIN user u ON f.idSender=u.idUser WHERE status = 0 and idReceiver =?";
    @Override
    public void makeFriend(int idFriend, int idUser) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(MAKE_FRIEND_SQL);
        ps.setInt(1, idFriend);
        ps.setInt(2, idUser);
        ps.executeUpdate();
    }

    @Override
    public List<Friend> displayAllFriend(int idUser) throws SQLException {
        List<Friend> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALLFRIEND_SQL);
        ps.setInt(1,idUser);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String avatarFriend = resultSet.getString("avatar");
            String friendName = resultSet.getString("name");
            list.add(new Friend(avatarFriend, friendName));
        }
        return list;
    }

    @Override
    public List<Friend> displayListPending(int idUser) throws SQLException{
        List<Friend> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_FRIEND_PENDING_SQL);
        ps.setInt(1,idUser);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int idFriend = resultSet.getInt("idUser");
            String avatar = resultSet.getString("avatar");
            String name = resultSet.getString("name");
            list.add(new Friend(idFriend,avatar,name));
        }
        return list;


    }
    @Override
    public void acceptFriend(int idFriend) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ACCEPT_FRIEND_SQL);
        ps.setInt(1,idFriend);
        ps.executeUpdate();
    }

    public void setAcceptFriendSql(int idFriend, int idUser) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(ACCEPT_FRIEND_SQL2);
        ps.setInt(1, idFriend);
        ps.setInt(2,idUser);
        ps.executeUpdate();

    }

}