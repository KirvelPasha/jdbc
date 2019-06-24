package dao.impl;

import dao.interfaces.BookingDao;
import entity.Booking;
import jdbc.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
    private static final String SQL_QUERY_ADD_BOOKING = "INSERT INTO Booking (StartDate,EndDate,PersonId,ApartmentId) Values (?,?,?,?)";

    private static final String SQL_QUERY_GET_BOOKING = "Select *\n" +
            "From Booking Join Apartment\n" +
            "On Booking.apartmentId = Apartment.id\n" +
            "Where Booking.PersonId = ?";
    private static final String SQL_QUERY_DELETE_BOOKING = "DELETE FROM Booking WHERE id = ?";


    @Override
    public void addBooking(Booking booking) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_BOOKING) ;
            preparedStatement.setString(1,booking.getStartDate());
            preparedStatement.setString(2,booking.getEndDate());
            preparedStatement.setInt(3,booking.getPersonId());
            preparedStatement.setInt(4,booking.getApartmentId());
            preparedStatement.executeUpdate();
        } finally {

        }
    }

    @Override
    public List<Booking> getMyBooking(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Booking> bookings = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_BOOKING);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            bookings = initBooking(resultSet);
        } finally {

        }
        return bookings;
    }

    @Override
    public void deleteBookingById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_BOOKING);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } finally {
        }

    }

    private  List<Booking> initBooking(ResultSet resultSet) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (resultSet.next()){
            Booking booking = new Booking();
            booking.setId(resultSet.getInt("Id"));
            booking.setStartDate(resultSet.getString("StartDate"));
            booking.setEndDate(resultSet.getString("EndDate"));
            booking.setApartmentId(resultSet.getInt("ApartmentId"));
            booking.setPersonId(resultSet.getInt("PersonId"));
            bookings.add(booking);
        }
        return bookings;
    }
}
