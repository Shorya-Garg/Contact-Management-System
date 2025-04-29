package Controller_Package;

import Service_Package.UserService;
import java.util.Scanner;

public class UserController {
    private UserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);
    
    

    public void start() {
    	userService.addUser("Ujjwal", "98765432", "ujjwal@gmail.com");
    	userService.addUser("Aditya", "986723432", "aditya@gmail.com");
    	userService.addUser("Shorya", "9445432", "shorya@gmail.com");
    	userService.addUser("Shreya", "9445432456", "shreya@gmail.com");
        String choice;
        do {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("Add Contact");
            System.out.println("View Contacts");
            System.out.println("Search Contact");
            System.out.println("Delete Contact");
            System.out.println("Update Contact");
            System.out.println("Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();
            choice = choice.toLowerCase();

            if(choice.equals("add contact")) {
                addContact();
            } else if (choice.equals("view contacts")) {
                userService.viewUsers();
            } else if (choice.equals("search contact")) {
                searchContact();
            } else if (choice.equals("delete contact")) {
                deleteContact();
            } else if (choice.equals("update contact")) {
                updateContact();
            } else if (choice.equals("exit")) {
                System.out.println("Thank you for using Contact Manager. Goodbye!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (!choice.equals("exit"));
    }

    private void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        userService.addUser(name, phone, email);
    }

    private void searchContact() {
        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();
        userService.searchUser(name);
    }

    private void deleteContact() {
        System.out.print("Enter Name to Delete: ");
        String name = scanner.nextLine();
        userService.deleteUser(name);
    }

    private void updateContact() {
        System.out.print("Enter Name to Update: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        userService.updateUser(name, phone, email);
    }
}
