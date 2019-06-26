package dao.interfaces;

import entity.Apartment;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ApartmentDao {

    List<Apartment> getCheaperApartments(int price) throws SQLException;

    List<Apartment> getAll() throws SQLException;

    void create(Apartment apartment) throws SQLException;

}
