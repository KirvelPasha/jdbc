package interfaces;

import entity.Apartment;

import java.sql.SQLException;
import java.util.List;

public interface ApartmentService {

    List<Apartment> getAll() throws SQLException;

    List<Apartment> getCheaperApartments(int price) throws SQLException;
}
