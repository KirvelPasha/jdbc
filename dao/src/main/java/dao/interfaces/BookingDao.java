package dao.interfaces;


import entity.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingDao {

    void addBooking(Booking booking) throws SQLException;

    List<Booking> getMyBooking(int id) throws SQLException;

    void deleteBookingById(int id) throws SQLException;

}
