package Uebung6;

import java.util.Random;

public class GameOfLife {

    public static void main(String[] args) {

        Random random = new Random();

        int[][] field = new int[10][10];

        /*
        int[][] field = new int[][] {
                {1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 1}
                };
        */

        for (int i = 0; i < field.length; i++) { //generates 1 or 0 to indexes of the array randomly
            for (int j = 0; j < field.length; j++) {
                field[i][j] = random.nextInt(1 + 1 - 0); //min 0, max 1; 1 is alive, 0 is dead
            }
        }


        System.out.println("Original field");
        printArray(field);

        int generationRuns = 10;

        for (int i = 0; i < generationRuns; i ++) { //for every loop, a new generation will be generated and printed out

            field = newGeneration(field);

            System.out.println("Generation "+ (i+1));
            printArray(field);

        }

    }

    public static int[][] newGeneration(int[][] newGen) { //method to create the new generation to replace field

        int aliveNeighbor = 0;

        for (int i = 0; i < newGen.length; i++) {

            for (int j = 0; j < newGen.length; j++) {

                aliveNeighbor = checkNeighbor(newGen, (i-1), (j-1)) + checkNeighbor(newGen, (i+1), (j-1)) + checkNeighbor(newGen, (i-1), (j+1)) + checkNeighbor(newGen, i, (j-1))
                                + checkNeighbor(newGen, (i-1), j) + checkNeighbor(newGen, (i+1), j) + checkNeighbor(newGen, i, (j+1)) + checkNeighbor(newGen, (i+1), (j + 1));
                //calls method to check for the neighbors and adds the values together to check how many alive neighbors newGen[i][j] has

                if (aliveNeighbor < 2) {
                    newGen[i][j] = 0;
                } else if (aliveNeighbor >= 2 && aliveNeighbor <=3 && newGen[i][j] == 1) {
                    newGen[i][j] = 1;
                } else if (aliveNeighbor == 3 && newGen[i][j] == 0){
                    newGen[i][j] = 1;
                } else if (aliveNeighbor >= 4) {
                    newGen[i][j] = 0;
                }
                //if there's less than 2 alive neighbors, or if there's more than 3 neighbors, the cell will die
                /*
                if there's 2 to 3 neighbors, the cell is alive, if the cell has exactly 3 neighbors, it is born,
                */

            }
        }

        return newGen;
    }

    public static int checkNeighbor(int[][] newGen, int x, int y) { //method to see if index to check is out of bounds or not, if out of bounds, set the "neighbor" to 0

        try {

            return newGen[x][y]; //if in bounds, return the value of the current cell

        } catch (ArrayIndexOutOfBoundsException exception) {

            return 0;

        }

    }

    public static void printArray(int[][] arrayPrint) { //method used to print arrays

        for (int i = 0; i < arrayPrint.length; i++) {

            for (int j = 0; j < arrayPrint.length; j ++) {

                System.out.print(arrayPrint[i][j] + "  ");

            }

            System.out.println();
        }

    }

}
