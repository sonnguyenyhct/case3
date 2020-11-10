package service;

import model.Post;
import sun.awt.image.ImageWatched;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PostService implements IPostService {

    Connection connection = ConnectionDB.getConnection();
    private static final String INSERT_POST_SQL = "INSERT INTO POST(idUser,image,content,timePost) values (?,?,?,?)";
    //    private static final String SELECT_POST_SQL = "SELECT * FROM post WHERE idPost = ?;";
    //    hiển thị tất cả bài đăng trên trang chủ
    private static final String SELECT_ALL_POST_HOME_SQL = "select u.idUser idUser, p.idPost idPost, u.avatar avt, u.name name, p.timePost timePost, p.image img, p.content content, count(pl.idPost) likeCount\n" +
            "from Post p\n" +
            "         left join user u on p.idUser = u.idUser\n" +
            "         left join PostLike pl on p.idPost = pl.idPost\n" +
            "group by p.idPost\n" +
            "order by idPost desc ";
    //    hiển thị tất cả bài đăng trên trang cá nhân
    private static final String SELECT_ALL_POST_PERSONAL_SQL = "select p.idPost idPost, u.avatar avt, u.name name, p.timePost timePost, p.image img, p.content content, count(pl.idPost) likeCount\n" +
            "from Post p\n" +
            "         left join user u on p.idUser = u.idUser\n" +
            "         left join PostLike pl on p.idPost = pl.idPost\n" +
            "where u.idUser = ?\n" +
            "group by idPost";
    private static final String DELETE_POST_SQL = "delete from Post where idPost = ?;";
    private static final String UPDATE_POST_SQL = "update Post set content = ? where idPost = ?;";

    @Override
    public boolean insertPost(Post post, int idUser) {
        PreparedStatement ps = null;
        int check = 0;
        try {
            ps = connection.prepareStatement(INSERT_POST_SQL);
            ps.setInt(1, idUser);
            ps.setString(2, "page/images/resources/" + post.getImage());
            ps.setString(3, post.getContent());
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

//    @Override
//    public Post selectPost(int idPost) {
//        try {
//            PreparedStatement ps = connection.prepareStatement(SELECT_POST_SQL);
//            ps.setInt(1,idPost);
//            ResultSet resultSet = ps.executeQuery();
//            if (resultSet.next()){
//                String image = resultSet.getString("image");
//                String content = resultSet.getString("content");
//                Date date = resultSet.getDate("timePost");
//                LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
//                return new Post(idPost,image,content,localDateTime);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<Post> selectAllPostHome() {
        List<Post> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_POST_HOME_SQL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer idUser = resultSet.getInt("idUser");
                Integer idPost = resultSet.getInt("idPost");
                String avatar = resultSet.getString("avt");
                String userName = resultSet.getString("name");
                Date date = resultSet.getDate("timePost");
                LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
                String image = resultSet.getString("img");
                String content = resultSet.getString("content");
                Integer likeCount = resultSet.getInt("likeCount");
                list.add(new Post(idPost,avatar, userName, localDateTime, image, content, likeCount, idUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List< Post> selectAllPostPersonal(int idUser) {
        List<Post> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_POST_PERSONAL_SQL);
            ps.setInt(1,idUser);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Integer idPost = resultSet.getInt("idPost");
                String avatar = resultSet.getString("avt");
                String userName = resultSet.getString("name");
                Date date = resultSet.getDate("timePost");
                LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
                String image = resultSet.getString("img");
                String content = resultSet.getString("content");
                Integer likeCount = resultSet.getInt("likeCount");
                list.add( new Post(idPost,avatar, userName, localDateTime, image, content, likeCount, idUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deletePost(int idPost) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_POST_SQL);
        ps.setInt(1, idPost);
        ps.executeUpdate();
    }


    @Override
    public void updatePost(Post post, int idPost) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_POST_SQL);
        ps.setString(1, post.getContent());
        ps.setInt(2, idPost);
        ps.executeUpdate();
    }
}