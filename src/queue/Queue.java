package queue;


import java.util.Arrays;
/**
 * Arrays, linked lists, trees, etc. are best for data that represents real objects.
 * Stacks & Queues are instead used to complete a task and are soon after discarded.
 *
 * Stacks & Queues
 *  Allow only a single item to be added or removed at a time.
 *  Stacks allow access to the last item inserted (LIFO).
 *  Queues allow access to the first item inserted (FIFO).
 *
 * This class represent the implementation of the Queue.
 */
public class Queue {

    private String[] theQueue;
    private int queueSize;
    //Set the queue empty.
    private int front, rear, numberOfItems = 0;

    public Queue(int size) {
        queueSize = size;
        theQueue = new String[queueSize];
        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen
        Arrays.fill(theQueue, "-1");
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
       // queue.offer("21");
       // queue.offer("12");
        queue.priorityInsert("21");
        queue.priorityInsert("3");
        queue.priorityInsert("43");
        queue.priorityInsert("14");
        queue.displayQueue();
        //queue.poll();
        //queue.displayQueue();


    }


    /**
     * This method display the Queue.
     */
    public void displayQueue() {
        for (int i = 0; i < queueSize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < queueSize; i++) {
            if (theQueue[i].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", theQueue[i]));
        }
        System.out.println("|");
    }


    /**
     * This method insert a value into the Queue.
     * @param input represent the value that we want to insert.
     */
    public void offer(String input) {
        if (numberOfItems < queueSize) {
            theQueue[rear] = input;
            rear++;
            numberOfItems++;
        } else {
            System.out.println("The queue is full");
        }
    }


    /**
     * This method remove the first element inserted into the Queue.
     */
    public void poll() {
        if (numberOfItems > 0) {
            // Just like in memory an item isn't deleted, but instead is just not available
            theQueue[front] = "-1";
            front++;
            numberOfItems--;
        } else {
            System.out.println("The queue is empty");
        }
    }


    /**
     * This method print the first element inserted into Queue.
     */
    public void peek() {
        System.out.println("The first element is " + theQueue[front]);
    }


    /**
     * This method will add items in order from high to low.
     * @param input the element we want to insert.
     */
    public void priorityInsert(String input) {
        int i;

        if (numberOfItems == 0) {
            offer(input);
        } else {
            for (i = numberOfItems; i >= 0; i--) {
                if (Integer.parseInt(input) > Integer.parseInt(theQueue[i])) {
                    theQueue[i + 1] = theQueue[i];
                }else break;
            }
            theQueue[i + 1] = input;
            rear++;
            numberOfItems++;
        }
    }


}
