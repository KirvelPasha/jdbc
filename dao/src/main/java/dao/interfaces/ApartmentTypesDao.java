package dao.interfaces;

import entity.ApartmentTypes;

import java.sql.SQLException;
import java.util.List;

public interface ApartmentTypesDao {
    List<ApartmentTypes> getAll() throws SQLException;
}
