package interfaces;

import entity.Person;

import java.sql.SQLException;

public interface PersonService {

    void signUp (Person person) throws SQLException;
}
