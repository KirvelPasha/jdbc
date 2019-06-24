package menu;

import java.sql.SQLException;

public interface Menu {

    void printTextMenu();

    void printMenu() throws SQLException;
}
