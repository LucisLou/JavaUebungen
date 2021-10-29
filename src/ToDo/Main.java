package ToDo;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String username = "";
        String password = "";
        String password2 = "";
        boolean loginSuccess = false; //used for login check
        boolean userExists = false; //used to check existing user
        boolean doContinue = false; //used so that the program doesn't end unless the user does not wish to continue

        System.out.println("------ To Do ------");
        System.out.printf("What would you like to do?%n[1] Login%n[2] Create New User%n");

        String userChoice = scan.nextLine();

        while (!userChoice.equals("1") && !userChoice.equals("2")) {
           System.out.println("Invalid input. Please type in either 1 for 'Login' or 2 for 'Create new User'");
           userChoice = scan.nextLine();
        }

        if (userChoice.equals("1")) { //login
            System.out.println(">[1] Login:");
            do {
                System.out.println("Insert your usename:");
                username = scan.nextLine();
                System.out.println("Insert your password:");
                password = scan.nextLine();
                loginSuccess = login(username, password);
            } while (!loginSuccess);
        } else { // create new user
            System.out.println(">[2] Create New User:");

            do {
                System.out.println("Insert a usename:");
                username = scan.nextLine();
                while (username.length() > 50) {
                    System.out.println("Input too large. Please insert your username with a max of 50 letters.");
                    username = scan.nextLine();
                }
                System.out.println("Insert your password:");
                password = scan.nextLine();
                while (password.length() > 30) {
                    System.out.println("Input too large. Please insert your password with a max of 30 letters.");
                    password = scan.nextLine();
                }

                do {
                    System.out.println("Repeat the password:");
                    password2 = scan.nextLine();
                    if(!password.equals(password2)) {
                        System.out.println("Passwords do not match!");
                    }
                } while (!password.equals(password2));

                userExists = checkNewUser(username);

            } while (userExists);

            createUser(username, password);
        }

        do {
            System.out.printf("What would you like to do?%n[1] View All Tasks%n[2] View Open Tasks%n[3] Create Task%n[4] Update Task%n");
            userChoice = scan.nextLine();

            while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3") && !userChoice.equals("4") && !userChoice.equals("5")) {
                System.out.println("Invalid input.");
                userChoice = scan.nextLine();
            }

            switch (userChoice) {
                case "1" -> viewTasks(username);
                case "2" -> viewOpenTasks(username);
                case "3" -> {
                    System.out.println("Please enter your task (max 25 letters):");
                    String task = scan.nextLine();
                    while (task.length() > 25) {
                        System.out.println("Input too large. Please insert your task name/description with a max of 25 letters.");
                        task = scan.nextLine();
                    }
                    createTask(username, task);
                }
                case "4" -> updateTask(username);
            }

            System.out.println("Continue? [Y/N]");

            do {
                userChoice = scan.nextLine();
                userChoice.toLowerCase();

                if (userChoice.equals("y")) {
                    doContinue = true;
                }
            } while (!userChoice.equals("y") && !userChoice.equals("n"));
        } while (doContinue);

    }

    private static boolean checkNewUser(String username) {
        //checks if username already exists

        boolean userExists = false;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT username FROM to_do_user WHERE username = '" + username + "'" );
            if (result.next()) { // if true, then user exists, since a result is given
                System.out.println("User already exists, please choose another username.");
                userExists = true;
            }
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return userExists;
    }

    private static void createUser(String username, String password) {
        //inserts new user in the database -> user table
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            String query = "INSERT INTO to_do_user (username, pswd) VALUES ('" + username + "','" + password + "')";

            Statement statement = conn.createStatement();
            statement.execute(query);
            statement.close();

            System.out.println("User with username " + username + " created successfully.");

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static boolean login(String username, String password) {
        //login method that checks if username exists and then is password for the specified username is correct, if all is successful, then returns success = true
        boolean success = false;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT username FROM to_do_user where username = '" + username + "'");

            if (!result.next()) { //if there is no next, that means no user with the specified username exists
                System.out.println("User does not exist. Please try again or create a new user.");
            } else {

                result = statement.executeQuery("SELECT pswd from to_do_user where username = '" + username + "' AND pswd = '" + password + "'");

                if (!result.next()) {
                    System.out.println("Password is incorrect, please try again.");
                } else {
                    System.out.println("Login successful.");
                    success = true;
                }

            }
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return success;
    }

    private static void createTask(String username, String task) {
        //creates task with the username as foreign key and task as the task description/name
        System.out.println(">[3] Create Task:");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){
            String query = "INSERT INTO tasks (username, task, status) VALUES ('" + username + "','" + task + "', 'open')";

            Statement statement = conn.createStatement();
            statement.execute(query);
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void viewTasks(String username) {
        //Lists all tasks belonging to the current user
        System.out.println(">[1] View All Tasks:");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            System.out.println("List of your tasks:");
            String query = "SELECT TASK_ID, task, status FROM tasks WHERE username = '" + username + "'";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            int columns = result.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                if (i == 1) {
                    System.out.print(String.format("%-10s", result.getMetaData().getColumnLabel(i)));
                } else {
                    System.out.print(String.format("%-26s", result.getMetaData().getColumnLabel(i)));
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------------");

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    if (i == 1) {
                        System.out.print(String.format("%-10s", result.getString(i)));
                    } else {
                        System.out.print(String.format("%-26s", result.getString(i)));
                    }
                }
            }
            System.out.println();
            result.close();
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void viewOpenTasks(String username) {
        System.out.println(">[2] View Open Tasks:");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            System.out.println("List of your open tasks:");
            String query = "SELECT TASK_ID, task, status FROM tasks WHERE username = '" + username + "' AND status = 'open'";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            int columns = result.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                if (i == 1) {
                    System.out.print(String.format("%-10s", result.getMetaData().getColumnLabel(i)));
                } else {
                    System.out.print(String.format("%-26s", result.getMetaData().getColumnLabel(i)));
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------------");

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    if (i == 1) {
                        System.out.print(String.format("%-10s", result.getString(i)));
                    } else {
                        System.out.print(String.format("%-26s", result.getString(i)));
                    }

                }
            }
            System.out.println();
            result.close();
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void updateTask(String username) {
        System.out.println(">[4] Update Task:");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do", "root", "")){

            //List tasks
            System.out.println("List of your tasks:");
            String query = "SELECT TASK_ID, task, status FROM tasks WHERE username = '" + username + "'";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            int columns = result.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                if (i == 1) {
                    System.out.print(String.format("%-10s", result.getMetaData().getColumnLabel(i)));
                } else {
                    System.out.print(String.format("%-26s", result.getMetaData().getColumnLabel(i)));
                }

            }
            System.out.println();
            System.out.println("-------------------------------------------------");

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    if (i == 1) {
                        System.out.print(String.format("%-10s", result.getString(i)));
                    } else {
                        System.out.print(String.format("%-26s", result.getString(i)));
                    }

                }
            }

            //Select task to update
            Scanner scan = new Scanner(System.in);
            boolean isNotNumber = false;
            String taskID = "";
            String userChoice = "";

            System.out.println();
            System.out.println("Select the task you wish to update by typing in its ID:");

            do {
                try{ //since the TASK_ID in the database is an int, it's better to parse the userChoice into int as well
                    taskID = scan.nextLine();
                    int number = Integer.parseInt(taskID);
                }
                catch (NumberFormatException ex){
                    System.out.println("Input is invalid. Please insert the TASK_ID of the task you wish to edit.");
                    isNotNumber = true;
                }
            } while (isNotNumber);


            result = statement.executeQuery("SELECT TASK_ID FROM tasks where TASK_ID = " + taskID + " AND username = '" + username + "'");

            if (!result.next()) { //if there is no next, that means no task with the specified taskID exists or username does not match
                System.out.println("Task with this TASK_ID does not exist or you do not have the rights to view/edit it.");
            } else {
                //Choice after successfully selecting task
                System.out.println("Choose your action for task #" + taskID + ":");
                System.out.printf("[1] Mark As Done%n[2] Edit Task Description");

                userChoice = scan.nextLine();

                while (!userChoice.equals("1") && !userChoice.equals("2")) {
                    System.out.println("Invalid input.");
                    System.out.println("Choose your action for task #" + taskID + ":");
                    System.out.printf("[1] Mark As Done%n[2] Edit Task Description");
                    userChoice = scan.nextLine();
                }
                //Update task choices
                if (userChoice.equals("1")) {
                    //Mark task as done
                    query = "UPDATE tasks SET status = 'done' WHERE TASK_ID = " + taskID;
                    statement.execute(query);
                    statement.close();
                    System.out.println("Task set as done successfully.");
                } else {
                    //Change task name/description
                    System.out.println("Choose your new description/name for task #" + taskID + " (max 25 letters):");
                    String taskUpdate = scan.nextLine();

                    while (taskUpdate.length() > 25) {
                        System.out.println("Input too large. Please insert your name/description with a max of 100 letters.");
                        taskUpdate = scan.nextLine();
                    }

                    query = "UPDATE tasks SET task = '" + taskUpdate + "' WHERE TASK_ID = " + taskID;
                    statement.execute(query);
                    statement.close();
                    System.out.println("Task updated successfully.");
                }
            }

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
