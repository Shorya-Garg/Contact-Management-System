package Service_Package;

import Entity_Package.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.Map;

public class UserService {
    private UserRepository repository = new UserRepository();

    public void addUser(String name, String phone, String email) {
        User existingUser = repository.findUserByName(name);
        if (existingUser != null && name.equals(existingUser.getName())) {
            existingUser.setPhoneNumber(phone);
            System.out.println("User already exists. Phone number updated.");
            return;
        }
        User user = new User(name, phone, email);
        repository.addUser(user);
        System.out.println("User added successfully.");
    }

    public void viewUsers() {
        if (repository.getAllUsers().isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        for (Map.Entry<User, User> entry : repository.getAllUsers().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void searchUserByName(String name) {
        boolean user = repository.findUserInitials(name);
        if (user == false) {
            System.out.println("User not found.");
        }
    }

    public void searchUserByNumber(String phone) {
        boolean user = repository.findUserByNumber(phone);
        if(user == false){
            System.out.println("User not found.");
        }
    }

    public void deleteUser(String name) {
        boolean deleted = repository.deleteUser(name);
        if (deleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void updateUser(String name, String phone, String email) {
        boolean updated = repository.updateUser(name, phone, email);
        if (updated) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
