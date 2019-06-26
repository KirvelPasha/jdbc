package dao.impl;

import dao.interfaces.CommentsDao;
import entity.Comments;
import jdbc.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
    private static final String SQL_QUERY_GET_Comments = "SELECT id, comment, apartment_id, person_id" +
            " FROM Comments WHERE apartmentId = ?";
    private static final String SQL_QUERY_ADD_Comment = "INSERT INTO Comments " +
            "(Comment,ApartmentId,PersonId) VALUES(?,?,?)";
    @Override
    public List<Comments> getComments(Long apartmentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Comments> comments = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_Comments);
            preparedStatement.setLong(1,apartmentId);
            resultSet = preparedStatement.executeQuery();
            comments = initComments(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return comments;
    }

    @Override
    public void addComment(Comments comments) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_Comment);
            preparedStatement.setString(1,comments.getComment());
            preparedStatement.setInt(2,comments.getApartmentId());
            preparedStatement.setInt(3,comments.getPersonId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private List<Comments> initComments(ResultSet resultSet) throws SQLException {
        List<Comments> comments = new ArrayList<>();
        while (resultSet.next()){
            Comments comment = new Comments();
            comment.setComment(resultSet.getString("Comment"));
            comment.setPersonId(resultSet.getInt("PersonId"));
            comment.setApartmentId(resultSet.getInt("Id"));
            comments.add(comment);
        }
        return comments;
    }
}
