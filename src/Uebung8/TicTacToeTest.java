package Uebung8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicTacToeTest {

    static char[][] tttFieldLose;
    static char[][] tttFieldWinPlayer;
    static char[][] tttFieldWinCP;

    @BeforeEach
    void initAll() {

        tttFieldLose = new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'O'},
                {'X', 'O', 'X'}
        };

        tttFieldWinPlayer = new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        }; //win at 02 11 20

        tttFieldWinCP = new char[][]{
                {'O', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

    }

    @Test
    void testCheckLosePlayer() {

        boolean expected = false;
        boolean outcome = TicTacToe.checkWinPlayer(tttFieldLose);

        System.out.println(expected == outcome);

    }

    @Test
    void testCheckWinPlayer() {

        boolean expected = true;
        boolean outcome = TicTacToe.checkWinPlayer(tttFieldWinPlayer);

        System.out.println(expected == outcome);

    }

    @Test
    void testCheckLoseCP() {

        boolean expected = false;
        boolean outcome = TicTacToe.checkWinCP(tttFieldLose);

        System.out.println(expected == outcome);

    }

    @Test
    void testCheckWinCP() {

        boolean expected = true;
        boolean outcome = TicTacToe.checkWinCP(tttFieldWinCP);

        System.out.println(expected == outcome);

    }

}
