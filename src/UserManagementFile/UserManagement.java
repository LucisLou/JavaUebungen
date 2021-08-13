package UserManagementFile;

import java.io.*;

public class UserManagement {

    public static void main(String[] args) throws IOException {
        readUsers();
        changeUsers("src/UserManagementFile/Users.txt", "Miriam A.", "Miriam C.");
        readUsers();
        System.out.println();
        addUser("src/UserManagementFile/Users.txt", "5", "Cool New", "Cool str. 14", "0420");
        readUsers();
        System.out.println();
        deleteUser("src/UserManagementFile/Users.txt", "Trevor");
        readUsers();
    }

    private static void readUsers() throws IOException {

        try (
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("src/UserManagementFile/Users.txt"))

        ) {
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                System.out.println(currentLine);
                currentLine = bufferedReader.readLine();
            }
        }

    }

    public static void changeUsers(String filePath, String userOldInfo, String userNewInfo) throws IOException {

        BufferedReader reader = null;
        //setting the BufferedReader reader to null to initialize the variable locally

        File userFile = new File(filePath);
        //initializing userFile with the File of the filePath chosen in the method parameters

        StringBuilder toBeModified = new StringBuilder();
        //StringBuilder is used for toBeModified to append lines later

        FileWriter writer = null;
        //setting the FileWriter writer to null to initialize the variable locally

        try {
            reader = new BufferedReader(new FileReader(userFile));
            //sets the reader to read the file called in the method

            String currentLine = reader.readLine();

            while (currentLine != null) {
                toBeModified.append(currentLine).append('\n');
                currentLine = reader.readLine();
            }
            //takes the entirety of the text file specified in userFile and inserts it into toBeModified

            String modifiedText = toBeModified.toString().replaceAll(userOldInfo, userNewInfo);
            //takes the entirety of toBeModified into modifiedText with replaced Strings specified in the method parameters

            writer = new FileWriter(userFile);
            //sets the writer to write on userFile

            writer.write(modifiedText);
            //writes modifiedText into userFile


        } catch (IOException e) {

            System.out.println("File not found or another exception happened.");
            e.printStackTrace();

        } finally {
            reader.close();
            writer.close();
            //close reader and writer

        }

    }

    public static void addUser(String filePath, String newUserID, String newUserName, String newUserAddress, String newUserZIP) throws IOException {

        BufferedReader reader = null;
        //setting the BufferedReader reader to null to initialize the variable locally

        File userFile = new File(filePath);
        //initializing userFile with the File of the filePath chosen in the method parameters

        FileWriter writer = null;
        //setting the FileWriter writer to null to initialize the variable locally

        StringBuilder newUserFile = new StringBuilder();
        //StringBuilder is used for newUserFile to append lines later

        try {
            reader = new BufferedReader(new FileReader(userFile));
            //sets the reader to read the file called in the method

            String currentLine = reader.readLine();

            while (currentLine != null) {
                newUserFile.append(currentLine).append('\n');
                currentLine = reader.readLine();
            }

            newUserFile.append(newUserID).append(',').append(newUserName).append(',').append(newUserAddress).append(',').append(newUserZIP).append('\n');
            //appends the new user info: newUserID, newUserName, newUserAddress, newUserZIP

            writer = new FileWriter(userFile);
            //sets the writer to write on userFile

            writer.write(newUserFile.toString());
            //writes newUserFile as the userFile



        } catch (IOException e) {

            System.out.println("File not found or another exception happened.");
            e.printStackTrace();

        } finally {
            reader.close();
            writer.close();

        }

    }

    public static void deleteUser(String filePath, String userToDelete) throws IOException {

        BufferedReader reader = null;
        //setting the BufferedReader reader to null to initialize the variable locally

        File userFile = new File(filePath);
        //initializing userFile with the File of the filePath chosen in the method parameters

        FileWriter writer = null;
        //setting the FileWriter writer to null to initialize the variable locally

        StringBuilder textDeletedUser = new StringBuilder();
        //StringBuilder is used for textDeleteUser to append lines later

        try {
            reader = new BufferedReader(new FileReader(userFile));
            //sets the reader to read the file called in the method

            String currentLine = reader.readLine();

            while (currentLine != null) {

                if (!currentLine.contains(userToDelete)) {
                    textDeletedUser.append(currentLine).append('\n');
                }
                //If the current line contains the user we want to delete, then nothing will happen and the next line will be read
                //otherwise, append the current line to textDeletedUser
                currentLine = reader.readLine();
            }

            writer = new FileWriter(userFile);
            //sets the writer to write on userFile

            writer.write(textDeletedUser.toString());
            //writes textDeleteUser as the userFile



        } catch (IOException e) {

            System.out.println("File not found or another exception happened.");
            e.printStackTrace();

        } finally {
            reader.close();
            writer.close();
            //close reader and writer

        }

    }

}
