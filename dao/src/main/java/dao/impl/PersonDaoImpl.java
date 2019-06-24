package dao.impl;

import dao.interfaces.PersonDao;
import entity.Person;
import jdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {

   private final String  SQL_QUERY_ADD_CLIENT = "INSERT INTO Person (login,name,password," +
            "phone_number,role,surname) VALUES(?,?,?,?,?,?)";

    @Override
    public void signUp(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_CLIENT);
            preparedStatement.setString(1,person.getLogin());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,person.getPassword());
            preparedStatement.setString(4,person.getPhoneNumber());
            preparedStatement.setString(5,person.getRole());
            preparedStatement.setString(6,person.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
