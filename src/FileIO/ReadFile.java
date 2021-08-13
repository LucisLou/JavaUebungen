package FileIO;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        readWithScanner();
        readWithBufferedReader();

    }

    private static void readWithScanner() throws FileNotFoundException {

        File helloFile = new File("src/FileIO/hello.txt");

        Scanner fileScanner = new Scanner(helloFile);
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

    private static void readWithBufferedReader() throws IOException {
        //better for bigger files                                                
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/FileIO/hello.txt")
        );
        String currentLine = bufferedReader.readLine();
        while (currentLine != null) {
            System.out.println(currentLine);
            currentLine = bufferedReader.readLine();
        }
        bufferedReader.close();

    }

}
