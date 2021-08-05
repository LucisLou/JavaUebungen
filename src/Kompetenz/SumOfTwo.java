package Kompetenz;

import java.util.Arrays;
import java.util.HashSet;

public class SumOfTwo {

    public static void main(String[] args) {

        int[] a = {4, 60, 20, 10, 33, 19, 700};
        int[] b = {10, 8, 63, 72, 40, 10, 3};
        int v = 73;

        System.out.println(
                "Set a: " + Arrays.toString(a) + "\n" + "Set b: " + Arrays.toString(b) + "\n"
                + "Check if there is a sum of two for "+ v + " : " + sumOfTwo(a, b, v));

    }

    public static boolean sumOfTwo (int[] a, int[] b, int v) {

        HashSet<Integer> hashB = new HashSet<Integer>();
        boolean checkIfSum = false;

        for (int i = 0; i < b.length; i++) {
           hashB.add(b[i]);
        } //converts the array b[] into a HashSet, as it is more efficient to search for a value in a HashSet than an array

        for (int i = 0; i < a.length; i++) {

            if (hashB.contains(v - (a[i]))) {
                //since a + b = v, if you look for either a or b when you have v and either a or b, then for example you can search the missing integer with b = v - a.
                checkIfSum = true;
                //if the HashSet hashB contains a value of v - the value of array a at the position of i, set checkIfSum true.
            }

        }

        return checkIfSum; //returns checkIfSum, if no sum was found, this would be false as it was initialized with false.

    }

}
