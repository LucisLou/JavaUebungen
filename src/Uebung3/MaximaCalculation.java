package Uebung3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaximaCalculation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        System.out.println("Please insert your numbers you wish to calculate the maximum of. Insert q to quit:");

        String userInput = "";

        int inputNumberConvert;

        while (!userInput.equals("q")) { // !equals() instead of != for Strings
            userInput = scanner.nextLine();

            if (!userInput.equals("q")) {
                try { //when you need to check if an input would create an exception error, use try catch
                    inputNumberConvert = Integer.valueOf(userInput);
                    userNumbers.add(inputNumberConvert);
                } catch (Exception e) { //catches error
                    System.out.println("Invalid input");
                    System.out.println(e.getMessage());// Prints out message why the error happened
                }
            }
        }

        int max = Collections.max(userNumbers);
        System.out.printf("The maximum of your numbers is: %d", max);

    }

}
