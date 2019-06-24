package menu;

import java.sql.SQLException;
;
import java.util.Scanner;


public class ClientMenu implements Menu {

    @Override
    public void printTextMenu() {
        System.out.println();
        System.out.println("0-Back to main menu");
        System.out.println("\nutils.Input your variant: ");
    }

    @Override
    public void printMenu() throws SQLException {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while (flag){
            printTextMenu();
            switch (scanner.nextInt()){
                case 0:
                    flag = false;
                    break;
            }
        }

    }

}
