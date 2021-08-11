package OOP2;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Stack {

    public static class IntStack {

        private int stack[];
        private int lastOfStack; //used to determine where the "last" item of the stack is positioned at

        public IntStack (int size) {
        //constructor for IntStack with the size of the array determined by size

            stack = new int[size];
            lastOfStack = 0; //initialized lastOfStack with 0, as the first item is the last

        }

        public void push(int newElement) {

            if (lastOfStack == stack.length) {
                //checks if there are already as many items as the size of the array stack

                int[] stackExtended = new int[stack.length*2];
                //creates an array having the double size of stack, used to override stack later

                for (int i = 0; i < stack.length; i++) {
                    stackExtended[i] = stack[i];
                    //copies the items within stack into stackExtended
                }

                stack = stackExtended; //overrides stack with stackExtended
            }

            stack[lastOfStack] = newElement; //adds the new item at the position of lastOfStack
            lastOfStack++; //increases lastOfStack by 1

        }

        public int size() {
            return lastOfStack;
            //lastOfStack is used for the size as stack.length could be bigger than the amount of items put into the stack
        }

        public int pop() throws ArrayIndexOutOfBoundsException{
            int pop;
            //initializes pop which will be used as return value
            try {
                pop = stack[lastOfStack-1];
                //try if stack even contains an item, since lastOfStack is like the length of the array, the index will be lastOfStack-1
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new ArrayIndexOutOfBoundsException("Cannot remove at an item that does not exist! Stack empty!");
                //if there is no item in the stack, throws an error message
            }

            if (lastOfStack > 0) {
                //since the first index of an array is 0, lastOfStack cannot be < 0 but the first index of an array is 0, lastOfStack will only be subtracted if it's greater than 0
                //maybe redundant, as the try/catch above would already check if stack is empty or not, but this is to make sure that lastOfStack will not go below 0
                lastOfStack--;
            }

            return pop;
        }

        public int peek() throws ArrayIndexOutOfBoundsException{
            int peek;
            try {
                peek = stack[lastOfStack-1];
                //try if stack even contains an item, since lastOfStack is like the length of the array, the index will be lastOfStack-1
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new ArrayIndexOutOfBoundsException("Cannot peek at an item that does not exist! Stack empty!");
                //if there is no item in the stack, throws an error message
            }
            return peek;

        }

        public int[] pop(int n) throws ArrayIndexOutOfBoundsException{
            int[] pop = new int[n];
            //initialize the array pop with the size of n, amount of items to be deleted

            if ((lastOfStack - n) < 0) {
                throw new ArrayIndexOutOfBoundsException("Cannot delete more items than there are in a stack!");
                //if n is greater than lastOfStack, an error will be given, as you cannot delete more items than there are
            } else {
                for (int i = 0; i < n; i++ ) {
                    pop[i] = stack[(lastOfStack-1)-i];
                    //copies the last n items to be deleted into the array pop
                }
                lastOfStack -= n;
                //reduces lastOfStack by n
            }
            return pop;
        }

        public void printStack() {

            System.out.println("The stack contains following items: ");
            for (int i = 0; i < lastOfStack; i++) {
                System.out.print("{" + stack[i] + "} ");
            }

        }

    }

    public static class Main {

        public static void main(String[] args) {
            IntStack myStack = new IntStack(10);

            myStack.push(4);
            myStack.push(5);
            myStack.push(11);

            myStack.printStack();

            System.out.println();
            System.out.println("Peek: " + myStack.peek());

            System.out.println("Pop: " + myStack.pop());
            myStack.printStack();

            myStack.push(6);
            myStack.push(50);

            System.out.println();
            myStack.printStack();

            System.out.println();
            System.out.println("Pop the last 3 items: " + Arrays.toString(myStack.pop(3)));

            System.out.println();
            myStack.printStack();

            System.out.println();
            System.out.println("Items in stack: " + myStack.size());

            myStack.pop(2);
        }

    }

}
