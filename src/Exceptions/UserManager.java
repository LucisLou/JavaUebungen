package Exceptions;

public class UserManager {

    public static int USER_COUNT;
    private String firstName;
    private String lastName;
    private String title;
    private int age;

    public UserManager (String firstName, String lastname, String title, int age) throws InvalidAgeException{

        this.firstName = firstName;
        this.lastName = lastname;
        this.title = title;

        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age is invalid.");
        }
        this.age = age;

        USER_COUNT++;

    }
}
