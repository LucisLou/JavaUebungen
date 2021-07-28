package Uebung7;

import java.util.ArrayList;
import java.util.Random;

public class SortAList {

    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {

            list.add(random.nextInt(100 - 1) + 1);

        }

        System.out.println("unsorted list: ");
        printList(list);

        System.out.println(); //used as a visual break

        selectionSort(list);

        System.out.println("unsorted list: ");
        printList(list);
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {

        int tempSave = 0; //initializing a temporary (helper) integer which will be used during swapping by getting the value of the bigger number so that the bigger number doesn't get lost

        for (int i = 0; i < list.size(); i++) {

            for (int j = i+1; j < list.size(); j++) {

                if (list.get(j) < list.get(i)) {
                    tempSave = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tempSave);
                }

            }

        }

        return list;

    }

    public static void printList(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
