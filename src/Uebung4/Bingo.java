package Uebung4;

import java.util.Random;

public class Bingo {

    public static void main(String[] args) {

        Random random = new Random();

        char bingo [] = {'B', 'I', 'N', 'G', 'O'};


        int column [][] = {
                {0, 0, 0, 0, 0}, //i = 0
                {0, 0, 0, 0, 0}, //i = 1
                {0, 0, 0, 0, 0}, //i = 2
                {0, 0, 0, 0, 0}, //i = 3
                {0, 0, 0, 0, 0} // i = 4
           //j = 0  1  2  3  4
        };

        for (int i = 0; i <= column.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (i < 1) { //because you can't multiply by 0, a separate random generation is made since we need to calculate the min-max with a multiplication of 15*i for the bingo card
                    column[j][i] = 1 + random.nextInt(15 - (1 + 1));
                    for (int k = 0; k < j; k++) {
                        if (column[j][i] == column[k][i]) {
                            column[j][i] = 1 + random.nextInt(15 - (1 + 1));

                            j--;
                            /*
                             If the value of column at the index of [j][i] is identical with the value at the index of [k][i], then a new
                             value will be generated for column at the index of [j][i] by going back one step with j--.
                             */
                        }
                    }
                } else if (i >= 1 && i < column.length) {
                    column[j][i] = 15*i + 1 + random.nextInt(15*(i+1) - (15*i + 1) + 1);
                    for (int k = 0; k < j; k++) {
                        if (column[j][i] == column[k][i]) {
                            column[j][i] = 15*i + 1 + random.nextInt(15*(i+1) - (15*i + 1) + 1);
                            j--;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < bingo.length; i++) {
            System.out.print(" " + bingo[i] + "  ");
            if (i < bingo.length - 1) { // will only print the | divider until G
                System.out.print("|");
            }
        }

        System.out.println(); //line break after BINGO has been printed out

        for (int i = 0; i < column.length; i++) { //prints out all the values of column
            for (int j = 0; j < column.length; j++) {
                if ( i == 2 && j == 2) {
                    System.out.print("FREE|");
                } else {
                    if (column[i][j] < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + column[i][j] + " ");
                    if (j == 4) {
                        System.out.println();
                    } else {
                        System.out.print("|");
                    }
                }
            }
        }

    }

}
