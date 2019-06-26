package impl;

import dao.impl.ApartmentDaoImpl;
import dao.impl.ApartmentTypesDaoImpl;
import dao.interfaces.ApartmentDao;
import dao.interfaces.ApartmentTypesDao;
import entity.ApartmentTypes;
import interfaces.ApartmentTypeService;
import java.sql.SQLException;

public class ApartmentTypeServiceImpl implements ApartmentTypeService {
    private ApartmentTypesDao apartmentTypesDao = new ApartmentTypesDaoImpl();

    @Override
    public void create(ApartmentTypes apartmentTypes) throws SQLException {
        apartmentTypesDao.create(apartmentTypes);
    }
}
