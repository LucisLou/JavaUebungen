package Uebung7;

import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> germanToEnglish = new HashMap<String, String>();
        HashMap<String, String> englishToGerman = new HashMap<String, String>();

        int userOption = 1;

        String userInput1 = "";
        String userInput2 = "";

        boolean quit = false;

        do {

            System.out.println("What would you like to do?");
            System.out.printf("[1] Add a new word pair%n[2] Remove a word pair%n[3] Translate%n");

            userOption = validOption(0, 4);

            if (userOption == 1) {

                System.out.println("Are you inserting a new word pair as German to English, or English to German?");
                System.out.printf("[1] German to English%n[2] English to German%n");

                userOption = validOption(0, 3);

                if (userOption == 1) {

                    System.out.println("Enter the German word (will be stored in lowercase): ");
                    userInput1 = scanner.nextLine();
                    userInput1 = userInput1.toLowerCase();
                    System.out.println("Enter the English translation of that word (will be stored in lowercase): ");
                    userInput2 = scanner.nextLine();
                    userInput2 = userInput2.toLowerCase();

                    germanToEnglish.put(userInput1, userInput2);
                    englishToGerman.put(userInput2, userInput1);

                } else if (userOption == 2) {

                    System.out.println("Enter the English word (lowercase): ");
                    userInput1 = scanner.nextLine();
                    userInput1 = userInput1.toLowerCase();
                    System.out.println("Enter the German translation of that word (lowercase): ");
                    userInput2 = scanner.nextLine();
                    userInput2 = userInput2.toLowerCase();

                    englishToGerman.put(userInput1, userInput2);
                    germanToEnglish.put(userInput2, userInput1);

                }

            } else if (userOption == 2) {

                if (germanToEnglish.size() < 1) {

                    System.out.println("Cannot delete anything. The dictionary has no word pairs in it yet!");

                } else {

                    System.out.println("Current word pairs are in the dictionary (in German > English view): ");

                    for (String i : germanToEnglish.keySet()) {
                        System.out.println(i + " = " + germanToEnglish.get(i));
                    }

                    System.out.println("Do you wish to remove a German word or an English word?");
                    System.out.printf("[1] German%n[2] English%n");

                    userOption = validOption(0, 3);

                    if (userOption == 1) {

                        System.out.println("Which German word alongside its English translation do you wish to remove? Insert it below:");

                        userInput1 = scanner.nextLine();
                        userInput1 = userInput1.toLowerCase();

                        while (!germanToEnglish.containsKey(userInput1)) {

                            System.out.println("Input/German word is not in the dictionary, please insert a German word available in the dictionary you wish to delete.");

                        }

                        userInput2 = germanToEnglish.get(userInput1); //gets the English word, which is the value of the key userInput1 in germanToEnglish, and sets it as value for userInput2
                        germanToEnglish.remove(userInput1);
                        englishToGerman.remove(userInput2);

                    } else if (userOption == 2) {

                        System.out.println("Which English word alongside its German translation do you wish to remove? Insert it below:");

                        userInput1 = scanner.nextLine();
                        userInput1 = userInput1.toLowerCase();

                        while (!englishToGerman.containsKey(userInput1)) {

                            System.out.println("Input/English word is not in the dictionary, please insert an English word available in the dictionary you wish to delete.");

                        }

                        userInput2 = englishToGerman.get(userInput1);
                        englishToGerman.remove(userInput1);
                        germanToEnglish.remove(userInput2);

                    }

                }

            } else if (userOption == 3) {

                if (germanToEnglish.size() < 1) {

                    System.out.println("Cannot translate. The dictionary has no word pairs in it yet!");

                } else {

                    System.out.println("Insert the word you wish to translate: ");

                    userInput1 = scanner.nextLine();
                    userInput1 = userInput1.toLowerCase();

                    while (!englishToGerman.containsKey(userInput1) || !germanToEnglish.containsKey(userInput1)) {

                        System.out.println("Input word is not in the dictionary.");

                    }

                    if (germanToEnglish.containsKey(userInput1)) {

                        System.out.printf("%s translates to %s%n", userInput1, germanToEnglish.get(userInput1));

                    } else if (englishToGerman.containsKey(userInput1)) {

                        System.out.printf("%s translates to %s%n", userInput1, englishToGerman.get(userInput1));

                    }

                }

            }

            System.out.println("Do you wish to continue?");
            System.out.printf("[1] Continue%n[2] Quit%n");

            userOption = validOption(0, 3);

            if (userOption == 1) {
                quit = false;
            } else if (userOption == 2) {
                quit = true;
            }

        } while (!quit);

    }

    public static int validOption(int outerBoundsSmaller, int outerBoundsBigger){
        //used to read user input for the option chosen and checks the validity of the user input

        Scanner scanner = new Scanner(System.in);

        int userOption = 0;

        try {
            userOption = scanner.nextInt();

            while (userOption <= outerBoundsSmaller || userOption >= outerBoundsBigger) {
                System.out.println("This is an invalid input. Please enter the number of the option you want.");
                userOption = scanner.nextInt();
            }

        } catch (Exception e) {

        System.out.println("This is an invalid input. Please enter the number of the option you want.");

        }

        return userOption;

    }


}
