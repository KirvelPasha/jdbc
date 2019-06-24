package utils;

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
        System.out.println("Input phone number");
        person.setRole("User");
        return person;
    }

}
