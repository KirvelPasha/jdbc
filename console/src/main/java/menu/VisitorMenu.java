package menu;

import impl.ApartmentServiceImpl;
import impl.PersonServiceImpl;
import interfaces.ApartmentService;
import interfaces.PersonService;
import utils.Input;
import java.sql.SQLException;
import java.util.Scanner;

public class VisitorMenu implements Menu {
    private ApartmentService apartmentService = new ApartmentServiceImpl();
    private PersonService personService = new PersonServiceImpl();

    @Override
    public void printTextMenu() {
        System.out.println("1-Get all apartments");
        System.out.println("2-Get apartments by price");
        System.out.println("3-Sign up");
        System.out.println("\nInput your variant: ");
    }

    @Override
    public void printMenu() throws SQLException {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            printTextMenu();
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(apartmentService.getAll());
                    break;
                case 2:
                    System.out.println("Input price");
                    System.out.println(apartmentService.getCheaperApartments(scanner.nextInt()));
                    break;
                case 3:
                    personService.signUp(Input.inputClient());
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }


    }
}
