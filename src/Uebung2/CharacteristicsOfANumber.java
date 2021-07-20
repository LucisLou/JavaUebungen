package Uebung2;

import java.util.Scanner;

public class CharacteristicsOfANumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert a Number: ");

        int num = scanner.nextInt();

        if (num%2 == 0) {
            System.out.printf("%d is an even number.%n", num);
        } else {
            System.out.printf("%d is an odd number.%n", num);
        }

        System.out.println("Please insert your lucky number: ");

        int luckyNum = scanner.nextInt();

        if (num == luckyNum) {
            System.out.printf("The number previously inserted is your lucky number: %d! %n", num);
        } else {
            System.out.printf("The number previously inserted is not your lucky number: %d! %n", num);
        }

    }

}
