package Kompetenz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfTwoTest {

    static int[] a;
    static int[] bTrue;
    static int[] bFalse;
    static int v;

    @BeforeAll
    static void initAll(){

        a = new int[] {13, 5, 11, 6, 1, 8};
        bFalse = new int[] {1, 4, 6, 20, 6,  9};
        bTrue = new int[] {2, 0, 5, 20, 3, 10};
        v = 13;

    }

    @Test
    void checkTrue() {

        boolean outcome = SumOfTwo.sumOfTwo(a, bTrue, v);

        assertEquals(true, outcome);

    }

    @Test
    void checkFalse() {

        boolean outcome = SumOfTwo.sumOfTwo(a, bFalse, v);

        assertEquals(false, outcome);

    }
}
