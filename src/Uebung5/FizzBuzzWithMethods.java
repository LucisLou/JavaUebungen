package Uebung5;

public class FizzBuzzWithMethods {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
           fizzOrBuzz(i);
        }
    }

    public static void fizzOrBuzz(int i) {
        if ((i%3) == 0 && (i%5) == 0) { //checks if i is dividable by 3 and 5
            System.out.printf("FizzBuzz!(%d)%n", i);
        } else if ((i%3) == 0) { //checks if i is dividable by 3
            System.out.printf("Fizz!(%d)%n", i);
        } else if ((i%5) == 0) { //checks if i is dividable by 5
            System.out.printf("Buzz!(%d)%n", i);
        } else {
            System.out.printf("%d!%n", i);
        }
    }

}
