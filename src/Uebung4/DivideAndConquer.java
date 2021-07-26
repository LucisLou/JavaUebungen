package Uebung4;

import java.util.Random;

public class DivideAndConquer {

    public static void main(String[] args) {

        Random random = new Random();

        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100 + 1 - 0);
        }

        System.out.println("The initial array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();  //used for a break

        array = mergeSort(array); //calls mergeSort using the values of array

        System.out.println("The sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static int[] mergeSort(int[] array) { //mergeSort algorithm: divides array into halves, then divides the halves again until only parts of 2 (and one if odd array) values remain

        if (array.length > 1) { //makes sure this only happens as long as the array has 2 or more values
            int mid = array.length / 2;

            int[] left = new int[mid]; //left is as long as mid
            int[] right = new int[array.length - mid]; //right is as long as the remainder starting at mid

            for (int i = 0; i < mid ; i++) { //for loop to assign the values of the first half of array to left
                left[i] = array[i];
            }
            for (int i = mid; i < array.length; i++) { //for loop to assign the values of the second half of array to right; since the right starts after the middle of the original array, the for-loop starts at mid
                right[i - mid] = array[i]; //since the for-loop starts at mid, to ensure the loop assigns the first value at right[0], we will calculate the index of right with [i - mid]
                                           //since we assign the values from array to right starting from the mid point, and i starts at mid, we assign the value of array at the index of i
            }

            //Recursive merge sorting, breaking each halves into halves again
            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right); //calls the merge method with the values of left and right and then returns the result assigned to mergedArray to array
        }
        else { // returns the value of array if only one value exists
            return array;
        }

    }

    public static int[] merge(int[] left, int[] right) { //method to sort and merge the spliced parts, taking values of left and right

        int[] mergedArray = new int[left.length + right.length]; //mergedArray must have the length of left and right combined, since both are the halves of the original array

        int leftIndex, rightIndex, resultIndex; //since our checks will be done with while loops, these index integers will be used
        leftIndex = rightIndex = resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) { //while loop only runs while both left and right have values in them

            if (left[leftIndex] < right[rightIndex]) {
                mergedArray[resultIndex] = left[leftIndex];
                leftIndex += 1; //increases leftIndex by one, to go a step further
            } else {
                mergedArray[resultIndex] = right[rightIndex];
                rightIndex += 1; //increases rightIndex by one, to go a step further
            }

            resultIndex += 1; //increases resultIndex by one, to go a step further

        }

        //if the conditions for the previous while loop are no longer met, then left and right will be checked individually


        while (leftIndex < left.length) { //while loops runs only as long as left has values in it
            mergedArray[resultIndex] = left[leftIndex];
            leftIndex += 1;
            resultIndex += 1;
        }

        while (rightIndex < right.length) { //while loops runs only as long as right has values in it
            mergedArray[resultIndex] = right[rightIndex];
            rightIndex += 1;
            resultIndex += 1;
        }

        return mergedArray;

    }

}
