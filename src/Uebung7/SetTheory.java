package Uebung7;

import java.util.HashSet;
import java.util.Set;

public class SetTheory {

    public static void main(String[] args) {

        int[] a = { 49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34 };
        int[] b = { 39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49 };
        int[] c = { 41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10 };

        Set<Integer> unionSet = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {
            unionSet.add(a[i]);
            unionSet.add(b[i]);
            unionSet.add(c[i]);
        } //since a Set can only have unique values, you can simply add all values of a, b, and c, since those that are duplicate will not be added

        System.out.println("Union: " + unionSet);

        Set<Integer> intersection =  new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {

                for (int k = 0; k < c.length; k++) {

                    if (a[i] == b[j] && b[j] == c[k] && a[i] == c[k]) {

                        intersection.add(c[k]);

                    }
                    //for an intersection, only values that all three sets have in common are added

                }

            }

        }

        System.out.println("Intersection: " + intersection);

        Set<Integer> differenceSet =  new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {

                for (int k = 0; k < c.length; k++) {

                    if (a[i] != b[j] && b[j] != c[k] && a[i] != c[k]) {

                        differenceSet.add(c[k]);

                    }
                    //for a difference, only values neither sets have in common are added

                }

            }

        }

        System.out.println("Difference: " + differenceSet);

    }
}
