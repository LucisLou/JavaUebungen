package Uebung2;

import java.util.Scanner;

public class FreeTimeOrWorkTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Hey, what time is it now?%nGive the time in the 24h format in full integers (e.g. ... 9 10 ...):%n");

        int time = scanner.nextInt();

        while (time >= 25 || time <= 0) {
            System.out.printf("%d is not a valid input. Please insert the time in the 24h format in full integers (e.g. ... 9 10 ...):%n", time);
            time = scanner.nextInt();
        } //to avoid a wrong input

        String isWorkTime = switch (time) {
            case 8, 9, 10, 11, 14, 15, 16:
                yield "It's still work time!";
            case 12:
                yield "It's lunch break!";
            case 13:
                yield "Lunch break just ended.. Back to work!";
            case 1, 2, 3, 4, 5, 6, 7, 17, 18, 19, 20, 21, 22, 23, 24:
                yield "It's not work time! Hooray!";
            default:
                yield "invalid";
                //throw new IllegalStateException("Unexpected value: " + time);
        }; //Because this is a statement, it's ended with a semi-colon

        System.out.printf("It's %d o'clock! Which means: %s", time, isWorkTime);
    }
}
