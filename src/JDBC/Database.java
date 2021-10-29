package JDBC;

import java.sql.*;

public class Database {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pswd = ""; //no password, therefore empty
        String query = "";

        Person james = new Person("James", "Turner", 'm', "1990-03-10");
        Person audrey = new Person("Audrey", "Kingston", 'f', "1992-12-01");
        Person kai = new Person("Kai", "Widewood", 'o', "1993-01-15");

        try (Connection conn = DriverManager.getConnection(url, user, pswd)) {
            System.out.println("Connection to database established.");

            // query = "INSERT INTO people (fname, lname, gender, birthday) VALUES ('" + james.getFname() + "','" + james.getLname() + "','" + james.getGender() + "','" + james.getBirthday() + "')";
            //query = "INSERT INTO people (fname, lname, gender, birthday) VALUES ('" + audrey.getFname() + "','" + audrey.getLname() + "','" + audrey.getGender() + "','" + audrey.getBirthday() + "')";
            query = "INSERT INTO people (fname, lname, gender, birthday) VALUES ('" + kai.getFname() + "','" + kai.getLname() + "','" + kai.getGender() + "','" + kai.getBirthday() + "')";
            System.out.println(query);

            Statement statement = conn.createStatement();
            statement.execute(query);
            statement.close();

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

}
