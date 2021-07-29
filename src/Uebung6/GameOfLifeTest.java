package Uebung6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GameOfLifeTest {

        static int[][] field; //a value created ONLY FOR THE TEST, not to be confused as the same 2D int array field existing in GameOfLife.java


        @BeforeAll
        static void initAll(){
            field = new int[][]{
                                {1, 0, 1, 1, 1},
                                {0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 1},
                                {1, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0}
            };

            }
        //Before running the test, assigns values to field


        @Test
        void testNewGeneration() { //create method where the test takes place in, is not the method that will be tested itself!!

            int[][] expectedField = new int[][]{ //used to determine if method works as intended
                    {0, 0, 1, 0, 1},
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 1, 1},
                    {0, 0, 0, 0, 0}
            };

            int[][] nextGenField = GameOfLife.newGeneration(field);
            //calls the method newGeneration in GameOfLife.java using field as parameter and assigns the values into the newly created int array nextGenField

            System.out.println(Arrays.deepEquals(nextGenField, expectedField));
            //compares result of method with the expected result
        }



}
