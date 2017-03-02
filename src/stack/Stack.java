package stack;


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
 * This class represent the implementation of the Stack.
 */
public class Stack {

    private String[] theStack;
    private int stackSize;
    // Sets stack as empty
    private int topOfStack = -1;

    public Stack(int size) {
        stackSize = size;
        theStack = new String[stackSize];
        //Assigns the value of -1 to every value in the array so we can control what gets printed to screen.
        Arrays.fill(theStack, "-1");
    }


    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.displayStack();
        stack.push("32");
        stack.push("12");
        stack.pushMany("4 5 12 43");
        stack.displayStack();
        stack.popAll();
        stack.displayStack();

    }


    /**
     * This method display the Stack.
     */
    public void displayStack() {
        for (int i = 0; i < stackSize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < stackSize; i++) {
            if (theStack[i].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", theStack[i]));
        }
        System.out.println("|");
    }


    /**
     * This method push/insert a value in the Stack.
     * @param input the value we want to push.
     */
    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            theStack[topOfStack] = input;
        } else {
            System.out.println("The stack is full");
        }
    }


    /**
     * This method pop the last value inserted.
     */
    public void pop() {
        if (topOfStack >= 0) {
            // Just like in memory an item isn't deleted, but instead is just not available
            theStack[topOfStack] = "-1";
            theStack[topOfStack] = theStack[topOfStack--];
        } else {
            System.out.println("The stack is empty");
        }
    }


    /**
     * This method return the value that is on top of the Stack.
     * @return the top value.
     */
    public String peek(){
        return theStack[topOfStack];
    }


    /**
     * This method helps as to insert multiple values in the Stack.
     * @param multipleValues represent the values that we want to push.
     */
    public void pushMany(String multipleValues){
        String[] temp = multipleValues.split(" ");

        for (int i = 0; i < temp.length; i++) {
            push(temp[i]);
        }
    }


    /**
     * This method pop all the values in the Stack.
     */
    public void popAll(){
        for (int i = topOfStack; i >=0 ; i--) {
            pop();
        }
    }


}
