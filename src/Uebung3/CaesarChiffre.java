package Uebung3;

import java.util.Random;
import java.util.Scanner;

public class CaesarChiffre {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Give in your text to encrypt in English:");

        String text = scanner.nextLine();
        int key = random.nextInt((25 - 1) +1) + 1; //generate a random number between 1 and 26 using random.nextInt((max - min) + 1) + min;
        String encryptedText = "";

        for (int i = 0; i < text.length(); i++) {
            int z = text.charAt(i);
            char indexChar = text.charAt(i);

            if (z >= 65 && z <= 90) { //Only upper case letters

                z = z + key; // encryption

                if (z > 90) {
                    z -= 26; // -26 to start again at A because there are 26 letters in the English alphabet
                } /* else if (z < 65) { //only relevant for encrypting the message by using the same key in negative
                    z += 26;
                } */

                indexChar = (char)z;

            } else if (z >= 97 && z <= 122) { //only lower case letters

                z = z + key;

                if (z > 122) {
                    z -= 26;
                } /* else if (z < 97) {
                    z += 26;
                } */

                indexChar = (char)z;

            }

            encryptedText += indexChar; //writing the encrypted text by adding all the encrypted characters to the string
        }

        System.out.printf("%s%nKey generated for encryption: %d", encryptedText, key);

    }

}
