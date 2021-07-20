package Uebung2;

import java.util.Scanner;

public class FreeTimeOrWorkTimeIfElse {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Hey, what time is it now?%nGive the time in the 24h format in full integers (e.g. ... 9 10 ...):%n");

        int time = scanner.nextInt();

        String isWorkTime = "";

        while (time >= 25 || time <= 0) {
            System.out.printf("%d is not a valid input. Please insert the time in the 24h format in full integers (e.g. ... 9 10 ...):%n", time);
            time = scanner.nextInt();
        } //to avoid a wrong input

        if (time >= 1 && time <= 7) { //if time is between 1 and up to 7
            isWorkTime = "It's not work time! Hooray!";
        } else if (time >= 16) { //if time is greater or equals 16
            isWorkTime = "It's not work time! Hooray!";
        } else if (time >= 8 && (time < 16 && time != 12)) { //if time is greater or equal 8 and time is smaller than 16 and not 12
            isWorkTime = "It's work time!";
        } else if (time == 12) { //if time is 12
            isWorkTime = "It's lunch break!";
        }

        System.out.printf("It's %d o'clock! Which means: %s", time, isWorkTime);
    }

}
