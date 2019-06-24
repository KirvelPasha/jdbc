package menu;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu implements Menu {
   // private ClientService clientService = new ClientServiceImpl();
    @Override
    public void printTextMenu() {
        System.out.println("1-Get All Clients");
        System.out.println("2-Block Client");
        System.out.println("3-Get Clients who have been blocked");
        System.out.println("4-Deploy Client");
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
