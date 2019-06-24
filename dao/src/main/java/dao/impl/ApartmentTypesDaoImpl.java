package dao.impl;

import dao.interfaces.ApartmentTypesDao;
import entity.ApartmentTypes;
import jdbc.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentTypesDaoImpl implements ApartmentTypesDao {
    private static final String SQL_QUERY_GET_TYPES = "Select * From ApartmentTypes ";
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
