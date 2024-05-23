public class Profile {
    //Class attributes
    private String type;
    private String name;
    private String password;
    private String email;

    // Constructor
    public Profile(String type, String name, String password, String email) {
        this.type = type;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

// Getters and Setters For EditProfile Use Case
public String getName() {
    return this.name;
}

public void setName(String customerName) {
    this.name = name;
}

public String getPassword() {
    return this.password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getType() {
    return this.type;
}

public void setType(String location) {
    this.type = type;
}

public String getEmai() {
    return this.email;
}

public void setEmail(String email) {
    this.email = email;
}

// Method to show the profile
public void showProfile() {
    System.out.println(" Name: " + getName());
    System.out.println("Password: " + getPassword());
    System.out.println("Type: " + getType());
}

//Method to check credentials
public boolean checkCredentials(boolean enteredPassword) {
    return getPassword().equals(enteredPassword);
}

//Method to change credentials
public void changeCredentials(String newPassword) {
    try{
        if (newPassword.length() < 8) {
            throw new IllegalArgumentException("New Password Must be at least <8> characters long!!");
        }
        setPassword(newPassword);
        System.out.println("Credentials changed successfully.");
    } catch(IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

}