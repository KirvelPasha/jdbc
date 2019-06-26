package impl;

import dao.impl.ApartmentDaoImpl;
import dao.interfaces.ApartmentDao;
import entity.Apartment;
import interfaces.ApartmentService;

import java.sql.SQLException;
import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentDao apartmentDao = new ApartmentDaoImpl();

    @Override
    public List<Apartment> getAll() throws SQLException {
        return apartmentDao.getAll();
    }

    @Override
    public List<Apartment> getCheaperApartments(int price) throws SQLException {
        try {
           if (price <= 0) throw new IllegalArgumentException("Price is less than 0");
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            
        }
        return apartmentDao.getCheaperApartments(price);
    }

    @Override
    public void create(Apartment apartment) throws SQLException {
        apartmentDao.create(apartment);
    }
}
