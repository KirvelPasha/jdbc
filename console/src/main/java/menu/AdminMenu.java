package menu;
import impl.ApartmentServiceImpl;
import impl.ApartmentTypeServiceImpl;
import interfaces.ApartmentService;
import interfaces.ApartmentTypeService;
import utils.Input;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu implements Menu {
    private ApartmentService apartmentService = new ApartmentServiceImpl();
    private ApartmentTypeService apartmentTypeService = new ApartmentTypeServiceImpl();

    @Override
    public void printTextMenu() {
        System.out.println("1-Create apartment");
        System.out.println("2-Create type");
        System.out.println("0-Back to main menu");
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
                    apartmentService.create(Input.createApartment());
                    break;
                case 2:
                    apartmentTypeService.create(Input.createType());
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
