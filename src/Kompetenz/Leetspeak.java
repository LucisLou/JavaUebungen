package Kompetenz;

import java.util.Scanner;

public class Leetspeak {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //used for conversion later
        String leet = "@8(D3F6#!JK1MN0PQR$7UVWXY2"; //leet has the same length as alphabet with the characters in the same order as the alphabet in leetspeak
        String userText = "";
        String convertedText = "";
        char userTextChar = ' ';
        char alphabetChar = ' ';
        char leetChar = ' ';

        System.out.println("Please insert your text you want to convert into Leetspeak:");
        userText = scanner.nextLine();
        userText = userText.toUpperCase(); //To make this easier and more readable, otherwise all lower case letters have to be added to alphabet and the characters in leet have to be repeated in the string

        for (int i = 0; i < userText.length(); i++) {

            userTextChar = userText.charAt(i); //picks out the character of the user input at the position of i
            leetChar = 0; //always sets leetChar to 0, used later to check if something was converted or not
            for (int j = 0; j < alphabet.length(); j++) {

                alphabetChar = alphabet.charAt(j); //picks out the character of alphabet at the position of j

                if (userTextChar == alphabetChar) {
                    leetChar = leet.charAt(j);
                    convertedText += leetChar;
                    //if userTextChar is the same as alphabetChar, then the character of leet at the index of j is the value of leetChar, which will then be added to the String convertedText
                }
            }
            if (leetChar == 0) { //if leetChar remains unchanged at 0, then no conversion took place in the for loop before, which means the character was not found in alphabet
                convertedText += userTextChar; //adds the character from userTextChar to the conversion as is
            }

        }

        System.out.printf("Your text (in uppercase):%n%s%nIs converted to:%n%s", userText, convertedText);

    }

}
