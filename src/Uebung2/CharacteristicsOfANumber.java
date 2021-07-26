package Uebung2;

import java.util.Scanner;

public class CharacteristicsOfANumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert a Number: ");

        float num = scanner.nextFloat();

        if ((num%10) == 0) {
            System.out.printf("%f is a round number%n", num);
        } else {
            System.out.printf("%f is not a round number%n", num);
        }

        if (num%2 == 0) { //checks if number is even or odd by checking the remainder of the division by 2.
            System.out.printf("%f is an even number.%n", num);
        } else {
            System.out.printf("%f is an odd number.%n", num);
        }

        System.out.println("Please insert your lucky number: ");

        float luckyNum = scanner.nextFloat();

        if (num == luckyNum) { //checks if num is the same as luckyNum
            System.out.printf("The number previously inserted is your lucky number: %f! %n", num);
        } else {
            System.out.printf("The number previously inserted is not your lucky number: %f! %n", num);
        }

    }

}
