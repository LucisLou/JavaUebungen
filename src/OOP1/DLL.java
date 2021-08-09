package OOP1;

import java.util.Objects;

public class DLL {

    public static class ListElement <T> {

        private int value;
        private ListElement next;
        private ListElement prev;

        public ListElement (int value) {

            this.value = value;
            next = prev = null;

        }

        @Override
        public String toString() {
            return "{" + value +
                    "} ";
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (o instanceof Integer) {
                ListElement<T> other = new ListElement((Integer) o);
                return value == other.value;
            }

            return false;
        }

        /*public boolean equals(int other) {
            return value == other;
        }*/

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static class MyList<T> {

        private ListElement start;
        private ListElement end;
        //private int size;

        public MyList(int value) {

            start = new ListElement(value);
            end = new ListElement(value);

            //size = 0;

            start.next = end;
            end.prev = start;
        }

        public void addEnd(int value) {

            ListElement newEl = new ListElement(value);

            newEl.prev = end.prev;
            newEl.next = end;
            newEl.prev.next = newEl;

            //size++;

        }

        public void addStart(int value) {

            ListElement newEl = new ListElement(value);

            newEl.prev = start;
            newEl.next = start.next;
            start.next = newEl;
            newEl.next.prev = newEl;

            //size++;
        }

        public void removeElement(int value) {
            //if input value is available, "remove" it by replacing the links from the previous and next elements to one another

            ListElement current = start;

            while (current.next != null) {
                if (current.equals(value)) {

                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    //size--;

                }

                current = current.next;
            }

        }

        public void printList() {

            ListElement current = start;

            while (current.next != null) {

                System.out.print(current);
                current = current.next;

            }

        }
    }


    static class Main {

        public static void main(String[] args) {

            MyList myList = new MyList<Integer>(0);


            myList.addStart(9);
            myList.addEnd(11);
            myList.addStart(10);
            myList.addStart(8);

            System.out.println("List: ");
            myList.printList();

            System.out.println();
            //break line

            System.out.println("List after remove: ");
            myList.removeElement(10);
            myList.printList();

        }

    }



}
