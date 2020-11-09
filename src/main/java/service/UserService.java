package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{

    Connection connection = ConnectionDB.getConnection();

    private static final String INSERT_USER_SQL = "INSERT INTO user (name,userAcc,userPass,avatarCover,avatar) VALUES (?,?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE idUser = ?;";
    private static final String CHECK_LOGIN = "SELECT * FROM user WHERE userAcc = ? and userPass = ?;";
    private static final String CHECK_USERNAME = "SELECT * FROM user WHERE userAcc = ?;";
    private static final String SELECT_USER_FOR_USERNAME = "SELECT * FROM user WHERE userAcc = ?;";
    private static final String UPDATE_AVATAR_USER = "UPDATE user SET avatar = ? WHERE idUser = ?;";
    private static final String UPDATE_COVER_AVATAR_USER = "UPDATE user SET avatarCover = ? WHERE idUser = ?;";


    private static final String SELECT_ALL_USERS = "SELECT * FROM user";

    @Override
    public boolean insertUser(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL);
        ps.setString(1,user.getName());
        ps.setString(2,user.getUserAccount());
        ps.setString(3,user.getUserPassword());
        ps.setString(4,user.getAvatarCover());
        ps.setString(5,user.getAvatar());
        int i = ps.executeUpdate();
        return i > 0;
    }

    public boolean checkLogin(String userName, String password){
        try {
            PreparedStatement ps = connection.prepareStatement(CHECK_LOGIN);
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                String userAcc = resultSet.getString("userAcc");
                String userPass = resultSet.getString("userPass");
                String avatarCover = resultSet.getString("avatarCover");
                String avatar = resultSet.getString("avatar");
                user = new User( id,  name,  userAcc,  userPass,  avatarCover,  avatar);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean checkUserName(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement(CHECK_USERNAME);
            ps.setString(1,username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public User getUserFromUserName(String userName) {
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_FOR_USERNAME);
            ps.setString(1,userName);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("idUser");
                String name = resultSet.getString("name");
                String userAcc = resultSet.getString("userAcc");
                String userPass = resultSet.getString("userPass");
                String avatarCover = resultSet.getString("avatarCover");
                String avatar = resultSet.getString("avatar");

                return new User(id,name,userAcc,userPass,avatarCover,avatar);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public boolean updateAvatarUser(User user){
        int check = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AVATAR_USER);
            preparedStatement.setString(1, user.getAvatar());
            preparedStatement.setInt(2,user.getIdUser());

            check = preparedStatement.executeUpdate();
            return check > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean updateCoverAvatarUser(User user){
        int check = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COVER_AVATAR_USER);
            preparedStatement.setString(1, user.getAvatarCover());
            preparedStatement.setInt(2,user.getIdUser());

            check = preparedStatement.executeUpdate();
            return check > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
