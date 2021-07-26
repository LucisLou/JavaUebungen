package Kompetenz;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {10, 6, 8, 1, 3};

        System.out.println("Unsorted array:");
        printArray(array);

        array = selectionSort(array);

        System.out.println();

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static int[] selectionSort(int[] array) {

        int tempSave = 0; //initializing a temporary (helper) integer which will be used during swapping by getting the value of the bigger number so that the bigger number doesn't get lost

        for (int i = 0; i < array.length; i++) {

            for (int j = i+1; j < array.length; j++) {

                if (array[j] < array[i]) {
                    tempSave = array[i];
                    array[i] = array[j];
                    array[j] = tempSave;
                }
                /*
                array[j] is bigger than array[i], then the value of array[i] will be temporarily saved in tempSave and then array[i] gets the value of array[j]
                and array[j] will get the value of tempSave. This is done to swap the smaller value with the bigger value.
                 */
            }
        }

        return array;

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
