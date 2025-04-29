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
        int choice;
        do {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Search Contact by Number");
            System.out.println("5. Delete Contact");
            System.out.println("6. Update Contact");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    userService.viewUsers();
                    break;
                case 3:
                    searchContactByName();
                    break;
                case 4:
                    searchContactByNumber();
                    break;

                case 5:
                    deleteContact();
                    break;
                case 6:
                    updateContact();
                    break;
                case 7:
                    System.out.println("Thank you for using Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
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

    private void searchContactByName() {
        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();
        userService.searchUserByName(name);
    }

    private void searchContactByNumber() {
        System.out.print("Enter Number to Search: ");
        String phone = scanner.nextLine();
        userService.searchUserByNumber(phone);
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
