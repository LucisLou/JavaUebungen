package OOP2;

import java.util.Arrays;

public class Queue {

    public static class IntQueue {

        private int[] queue;
        private int firstOfQueue; //used to determine the "first" of the queue
        private int lastOfQueue; //used to determine the "last" of the queue, also relevant for the calculation of the size of the queue

        public IntQueue (int size) {

            queue = new int[size];
            //initializes queue with the given length size
            firstOfQueue = 0;
            lastOfQueue = 0;
            //first and last of queue initialized with 0

        }

        public void enqueue(int newElement) {
            if (lastOfQueue == queue.length) {
                //checks if there are already as many items as the size of the array queue

                int[] queueExtended = new int[queue.length*2];
                //creates an array having the double size of queue, used to override queue later

                for (int i = 0; i < queue.length; i++) {
                    queueExtended[i] = queue[i];
                    //copies the items within queue into queueExtended
                }

                queue = queueExtended; //overrides stack with stackExtended
            }
            queue[lastOfQueue] = newElement;
            //puts the new item in the position of lastOfQueue
            lastOfQueue++;
        }

        public int size() {
            int size = lastOfQueue - firstOfQueue;
            //since the size of the queue is the amount of items from first to last item, size is calculated with lastOfQueue - firstOfQueue;
            return size;
        }

        public int dequeue() throws ArrayIndexOutOfBoundsException {
            int dequeue;
            try {
                dequeue = queue[firstOfQueue];
                //checks if queue is empty
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new ArrayIndexOutOfBoundsException("You can't dequeue an empty queue!");
                //if queue is empty, throw an exception
            }
            if (firstOfQueue == lastOfQueue) {
                throw new ArrayIndexOutOfBoundsException("You can't dequeue an empty queue!");
                //if firstOfQueue == lastOfQueue, it means the queue is empty, if so, throws an exception
            }
            firstOfQueue++;
            //since the first item will be "deleted", increases firstOfQueue by one, further into the array queue
            return dequeue;
        }

        public int[] dequeue(int n) throws ArrayIndexOutOfBoundsException {
            int[] dequeue = new int[n];
            //initializes dequeue with the size of n

            if (((lastOfQueue-firstOfQueue) - n) < 0) {
                throw new ArrayIndexOutOfBoundsException("You cannot dequeue more items than the amount that exists!");
                //checks if there is even enough items in the queue to dequeue by n
                //if not, throws exception
            } else {
                for (int i = 0; i < n; i++) {
                    dequeue[i] = queue[(firstOfQueue)+i];
                    //copies the values of the items in queue to be removed into dequeue
                }
                firstOfQueue += n; //increases firstOfQueue by n
            }

            return dequeue;
        }

        public void printQueue() {

            System.out.println("The queue contains following items: ");
            for (int i = firstOfQueue; i < lastOfQueue; i++) {
                System.out.print("{" + queue[i] + "} ");
            }

        }

    }

    public static class Main {

        public static void main(String[] args) {

            IntQueue myQueue = new IntQueue(10);

            myQueue.enqueue(5);
            myQueue.enqueue(80);
            myQueue.enqueue(10);

            myQueue.printQueue();
            System.out.println();

            System.out.println("Dequeue: " + myQueue.dequeue());

            myQueue.printQueue();
            System.out.println();

            myQueue.enqueue(1);
            myQueue.enqueue(3);

            myQueue.printQueue();
            System.out.println();
            System.out.println("Items in the queue: " + myQueue.size());

            System.out.println("The first 2 items will be dequeued: " + Arrays.toString(myQueue.dequeue(2)));

            myQueue.printQueue();
            System.out.println();

            System.out.println("The first 2 items will be dequeued: " + Arrays.toString(myQueue.dequeue(3)));

        }

    }

}
