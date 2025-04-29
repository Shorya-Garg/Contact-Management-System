package Entity_Package;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private ArrayList<String> phoneNumber = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();

    public User(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber.add(phoneNumber);
        this.email.add(email);
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.add(phoneNumber);
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', phone='" + phoneNumber + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return name.equalsIgnoreCase(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}
