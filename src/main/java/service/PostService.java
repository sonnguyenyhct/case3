package service;

import javafx.geometry.Pos;
import model.Post;
import model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostService implements IPostService{
    public static void main(String[] args) {
        System.out.println(java.time.LocalDateTime.now());
    }

    Connection connection = ConnectionDB.getConnection();
    private static final String INSERT_POST_SQL = "INSERT INTO POST(idUser,image,content,timePost) values (?,?,?,?)";
    private static final String SELECT_POST_SQL = "SELECT * FORM post WHERE idPost = ?;";

    @Override
    public boolean insertPost(Post post,int idUser) {
        PreparedStatement ps = null;
        int check = 0;
        try {
            ps = connection.prepareStatement(INSERT_POST_SQL);
            ps.setInt(1,idUser);
            ps.setString(2,post.getImage());
            ps.setString(3,post.getContent());
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            ps.setDate(4, date);
            check = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Post selectPost(int idPost) {
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_POST_SQL);
            ps.setInt(1,idPost);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                String image = resultSet.getString("image");
                String content = resultSet.getString("content");
                Date date = resultSet.getDate("timePost");
                //return new Post(idPost,image,content,date);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Post> selectAllPost() {
        return null;
    }

    @Override
    public boolean deletePost(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updatePost(Post post) throws SQLException {
        return false;
    }
}
