package dao.impl;

import dao.interfaces.ApartmentTypesDao;
import entity.ApartmentTypes;
import jdbc.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentTypesDaoImpl implements ApartmentTypesDao {
    private static final String SQL_QUERY_GET_TYPES = "SELECT id,type From ApartmentTypes ";
    private final String  SQL_QUERY_ADD_APARTMENTTYPE ="INSERT INTO ApartmentTypes (type) VALUES(?)";
    @Override
    public List<ApartmentTypes> getAll() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<ApartmentTypes> apartmentTypes = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_TYPES);
            apartmentTypes = initApartmentTypes(resultSet);
        } finally {
        }
        return apartmentTypes;
    }

    @Override
    public void create(ApartmentTypes apartmentTypes) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_APARTMENTTYPE);
            preparedStatement.setString(1,apartmentTypes.getType());
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
                e.printStackTrace();
            }
        }

    }

    private List<ApartmentTypes> initApartmentTypes(ResultSet resultSet) throws SQLException {
        List<ApartmentTypes> apartmentTypesList= new ArrayList<>();
        while (resultSet.next()){
            ApartmentTypes apartmentTypes = new ApartmentTypes();
            apartmentTypes.setId(resultSet.getInt("id"));
            apartmentTypes.setType(resultSet.getString("type"));
            apartmentTypesList.add(apartmentTypes);
        }
        return apartmentTypesList;
    }
}
