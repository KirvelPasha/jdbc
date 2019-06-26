package dao.impl;

import dao.interfaces.ApartmentDao;
import entity.*;
import jdbc.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class ApartmentDaoImpl implements ApartmentDao {

    private static final String SQL_QUERY_GET_CHEAPER_APARTMENTS = "SELECT id, countplaces, countrooms, number, price, typeid" +
            "  FROM Apartments WHERE price <= ?";
    private static final String SQL_QUERY_GET_APARTMENTS = "SELECT id, countplaces, countrooms, number, price, typeid " +
            "FROM Apartments";
    private final String SQL_QUERY_ADD_APARTMENT = "INSERT INTO Apartments (number,countRooms,countPlaces," +
            "price,typeId) VALUES(?,?,?,?,?)";

    @Override
    public List<Apartment> getCheaperApartments(int price) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Apartment> apartments = null;
        try{
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_CHEAPER_APARTMENTS);
            preparedStatement.setInt(1,price);
            resultSet = preparedStatement.executeQuery();
            apartments = initApartment(resultSet);
        } finally {

        }
        return apartments ;
    }

    @Override
    public List<Apartment> getAll() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Apartment> apartments = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_APARTMENTS);
            apartments = initApartment(resultSet);
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return apartments;
    }

    @Override
    public void create(Apartment apartment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_APARTMENT);
            preparedStatement.setInt(1, apartment.getNumber());
            preparedStatement.setInt(2, apartment.getCountRooms());
            preparedStatement.setInt(3, apartment.getCountPlaces());
            preparedStatement.setInt(4, apartment.getPrice());
            preparedStatement.setInt(5, apartment.getTypeId());
            preparedStatement.executeUpdate();
        } finally {
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


    private List<Apartment> initApartment(ResultSet resultSet) throws SQLException {
        List<Apartment> apartments = new ArrayList<>();
        while (resultSet.next()) {
            Apartment apartment = new Apartment();
            apartment.setId(resultSet.getInt("Id"));
            apartment.setNumber(resultSet.getInt("number"));
            apartment.setCountRooms(resultSet.getInt("countrooms"));
            apartment.setCountPlaces(resultSet.getInt("countplaces"));
            apartment.setPrice(resultSet.getInt("price"));
            apartment.setTypeId(resultSet.getInt("typeid"));
            apartments.add(apartment);
        }
        return apartments;
    }

}
