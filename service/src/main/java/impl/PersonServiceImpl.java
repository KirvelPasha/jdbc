package impl;

import dao.impl.PersonDaoImpl;
import dao.interfaces.PersonDao;
import entity.Person;
import interfaces.PersonService;
import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao = new PersonDaoImpl();


    @Override
    public void signUp(Person person) throws SQLException {
        personDao.signUp(person);
    }
}
