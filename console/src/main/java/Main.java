import menu.Menu;
import menu.Role;
import menu.UserFabric;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static void printMainMenu(){
        System.out.println("1-Enter like visitor");
        System.out.println("2-Enter like client");
        System.out.println("3-Enter like admin");
        System.out.println("0-Exit");
    }
    public static void main(String[]args) throws SQLException {
        while (true){
            printMainMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("utils.Input number of variant: ");
            try {
                Role role =null;
                switch (scanner.nextInt()){
                    case 1:
                        role= Role.VISITOR;
                        break;
                    case 2:
                        role= Role.CLIENT;
                        break;
                    case 3:
                        role= Role.ADMIN;
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException("Wrong input variant! Please, try again!");
                }
                UserFabric userFabric = new UserFabric();
                Menu menu = userFabric.getMenu(role);
                menu.printMenu();
            }catch (InputMismatchException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
