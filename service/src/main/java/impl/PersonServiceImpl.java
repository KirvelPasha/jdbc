package impl;

import entity.Person;
import interfaces.PersonService;
import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {

    private PersonService personService = new PersonServiceImpl();

    @Override
    public void signUp(Person person) throws SQLException {
        personService.signUp(person);
    }
}
