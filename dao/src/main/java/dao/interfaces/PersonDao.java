package dao.interfaces;

import entity.Person;

import java.sql.SQLException;

public interface PersonDao {

    void signUp (Person person) throws SQLException;
}
