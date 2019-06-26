package utils;

import entity.Apartment;
import entity.ApartmentTypes;
import entity.Person;
import java.util.Scanner;

public class Input {

    public static Person inputClient() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login");
        person.setLogin(scanner.nextLine());
        System.out.println("Input name");
        person.setName(scanner.nextLine());
        System.out.println("Input surname");
        person.setSurname(scanner.nextLine());
        System.out.println("Input password");
        person.setPassword(scanner.nextLine());
        person.setRole("User");
        return person;
    }

    public static Apartment createApartment(){
        Apartment apartment = new Apartment();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        apartment.setNumber(scanner.nextInt());
        System.out.println("Input count rooms");
        apartment.setCountRooms(scanner.nextInt());
        System.out.println("Input count places");
        apartment.setCountPlaces(scanner.nextInt());
        System.out.println("Input type id");
        apartment.setTypeId(scanner.nextInt());
        System.out.println("Input price");
        apartment.setPrice(scanner.nextInt());
        return apartment;
    }

    public static ApartmentTypes createType(){
        ApartmentTypes apartmentTypes = new ApartmentTypes();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input type");
        apartmentTypes.setType(scanner.nextLine());
        return apartmentTypes;
    }

}
