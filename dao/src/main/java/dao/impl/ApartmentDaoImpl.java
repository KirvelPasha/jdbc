package dao.impl;

import dao.interfaces.ApartmentDao;
import entity.*;
import jdbc.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class ApartmentDaoImpl implements ApartmentDao {
    private static final String SQL_QUERY_GET_CHEAPER_APARTMENTS = "SELECT *  FROM Apartment WHERE price <= ?";
    private static final String SQL_QUERY_GET_APARTMENTS = "SELECT * FROM Apartment";
    private static final String SQL_QUERY_GET_APARTMENTS_BY_TYPE = "SELECT * FROM Apartment JOIN ApartmentTypes ON Apartment.typeId = ApartmentTypes.id WHERE type = ? ";
    private static final String SQL_QUERY_GET_APARTMENTS_BY_COUNTROOMS = "SELECT * From Apartment Join ApartmentTypes  On  Apartment.Typeid = ApartmentTypes.id WHERE countrooms = ?";
    private static final String SQL_QUERY_GET_APARTMENTS_BY_ID = "SELECT Id From Apartment";

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
            Close.connection(connection);
            Close.connection(preparedStatement);
            Close.connection(resultSet);
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
            Close.connection(connection);
            Close.connection(statement);
            Close.connection(resultSet);
        }
        return apartments;
    }

    @Override
    public List<Apartment> getApartmentsByType(String type) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Apartment> apartments = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_APARTMENTS_BY_TYPE);
            preparedStatement.setString(1,type);
            resultSet = preparedStatement.executeQuery();
            apartments = initApartment(resultSet);
        } finally {
            Close.connection(connection);
            Close.connection(preparedStatement);
            Close.connection(resultSet);
        }
        return apartments;
    }

    @Override
    public List<Apartment> getApartmentByCountRooms(int countRooms) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Apartment> apartmentList = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_APARTMENTS_BY_COUNTROOMS);
            preparedStatement.setInt(1,countRooms);
            resultSet = preparedStatement.executeQuery();
            apartmentList = initApartment(resultSet);

        }finally {
            Close.connection(connection);
            Close.connection(preparedStatement);
            Close.connection(resultSet);
        }
        return apartmentList;
    }

    @Override
    public List<Integer> getAllId() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Integer> collection = new ArrayList<>();
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_APARTMENTS_BY_ID);
            while (resultSet.next()) {
                collection.add(resultSet.getInt("Id"));
            }
        } finally {
            Close.connection(connection);
            Close.connection(statement);
            Close.connection(resultSet);
        }
        return collection;
    }


    private List<Apartment> initApartment(ResultSet resultSet) throws SQLException {
        List<Apartment> apartments = new ArrayList<>();
        while (resultSet.next()) {
            Apartment apartment = new Apartment();
            apartment.setId(resultSet.getInt("Id"));
            apartment.setNumber(resultSet.getInt("number"));
            apartment.setCountRooms(resultSet.getInt("count_rooms"));
            apartment.setCountPlaces(resultSet.getInt("count_places"));
            apartment.setPrice(resultSet.getInt("price"));
            apartment.setTypeId(resultSet.getInt("type_id"));
            apartments.add(apartment);
        }
        return apartments;
    }

}
