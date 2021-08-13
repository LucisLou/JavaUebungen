package Exceptions;

public class Main {

    public static void main(String[] args) {

        try {
            UserManager newUser1 = new UserManager("Amelia", "Turner", "none", -3);
        } catch (InvalidAgeException e) {
            e.printStackTrace();
            System.out.println("Age is not valid");
        } finally {
            System.out.println("User was allocated regardless if valid or not.");
        }
        System.out.println("Message to prove program still runs");
    }
}
