package Repository;

import Entity_Package.User;
import java.util.HashMap;

public class UserRepository {
    private HashMap<User, User> userDatabase = new HashMap<>();

    public void addUser(User user) {
        userDatabase.put(user, user);
    }

    public HashMap<User, User> getAllUsers() {
        return userDatabase;
    }

    public User findUserByName(String name) {
        for (User user : userDatabase.keySet()) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean findUserInitials(String name) {
    	boolean flag=false;
        for (User user : userDatabase.keySet()) {
        	String temp = user.getName().toLowerCase();
            if (temp.contains(name.toLowerCase())) {
                System.out.println(user);
                flag = true;
            }
        }
        return flag;
    }

    public boolean findUserByNumber(String phone) {
    	boolean flag=false;
        for (User user : userDatabase.keySet()) {
        	String temp = user.getPhoneNumber();
            if (temp.contains(phone)) {
                System.out.println(user);
                flag = true;
            }
        }
        return flag;
    }

    public boolean deleteUser(String name) {
        User user = findUserByName(name);
        if (user != null) {
            userDatabase.remove(user);
            return true;
        }
        return false;
    }

    public boolean updateUser(String name, String newPhone, String newEmail) {
        User user = findUserByName(name);
        if (user != null) {
            user.setPhoneNumber(newPhone);
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }
}
