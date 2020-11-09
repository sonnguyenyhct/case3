package service;

import javafx.geometry.Pos;
import model.Post;
import model.User;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface IPostService {

    boolean insertPost(Post post,int idUser) throws SQLException;
    //    Post selectPost(int idPost);
    List<Post> selectAllPostHome();
    List<Post> selectAllPostPersonal(int idUser);
    void deletePost(int id) throws SQLException;
    void updatePost(Post post,int idPost) throws SQLException;

}