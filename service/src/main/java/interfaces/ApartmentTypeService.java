package interfaces;

import entity.ApartmentTypes;

import java.sql.SQLException;

public interface ApartmentTypeService {
    void create(ApartmentTypes apartmentTypes) throws SQLException;
}
