package Uebung3;

public class Multiplications {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) { //runs until i is 10
            System.out.printf("Times %d:%n", i);
            for (int j = 1; j <= 10; j++){ //runs until j is 10
                int result = i * j;
                System.out.printf("%d * %d = %d%n", j, i, result);
            }

        }

    }

}
