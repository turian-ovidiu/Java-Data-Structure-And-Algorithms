package arrayStructuresAndAlgorithms;

/**
 * This class represent the array structure and the most common sorting algorithms.
 */
public class ArrayStructures {

    private int[] theArray;
    private int arraySize;

    /**
     * Setup the array.
     * @param size the size of the array.
     */
    public ArrayStructures(int size) {
        arraySize = size;
        theArray = new int[50];
        generateArray();
    }

    /**
     * Generate the random array between 10 and 50.
     */
    private void generateArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    /**
     * This method display the array.
     */
    public void displayArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < arraySize; i++) {
            System.out.print(String.format("| %2s " + " ", theArray[i]));
        }
        System.out.println("|");
    }

    /**
     * This method return the value of the given index.
     * @param index represent the index of the array.
     * @return the value of the index.
     */
    public int getValueIndex(int index) {
        if (index < arraySize) {
            return theArray[index];
        }
        return 0;
    }

    /**
     * This method check if we have a given value in the array.
     * @param value the value to search.
     * @return true/false.
     */
    public boolean containValue(int value) {
        boolean valueInArray = false;
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    /**
     * This method insert a value in the array.
     * @param value the given value.
     */
    public void insertValue(int value) {
        if (arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    /**
     * This method delete an given index from the array.
     * @param index the index that we want to delete.
     */
    public void deleteIndex(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    /**
     * This method search for the given value in the array and display the index of the value.
     * @param value the value we need to search.
     */
    public void linearSearch(int value) {
        boolean valueInArray = false;
        String indexValue = "";

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
                indexValue += i + " ";
            }
        }
        if (!valueInArray) {
            indexValue = "None";
        }
        System.out.println("The value " + value + " was found at the following " + indexValue);
    }

    /**
     * In computer science , binary search , also known as half-interval search or logarithmic search,
     * is a search algorithm that finds the position of a target value within a sorted array.
     * @param value the value we want to search.
     */
    public void binarySearch(int value) {
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            if (theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else if (theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else {
                System.out.println("The value was found at the index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
    }


    /**
     *Bubble sort, sometimes referred to as sinking sort,
     * is a simple sorting algorithm that repeatedly steps through the list to be sorted,
     *compares each pair of adjacent items and swaps them if they are in the wrong order.
     * Average performance	O(n^2).
     */
    public void bubbleSort() {
        for (int i = arraySize - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    swapValue(j, j + 1);
                }
            }

        }
    }

    /**
     * Just swap two index values.
     * @param one first index of the array.
     * @param two second index of the array.
     */
    private void swapValue(int one, int two) {
        int temp = theArray[one];
        theArray[one] = theArray[two];
        theArray[two] = temp;
    }

    /**
     * In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort.
     * It has O(n^2) time complexity, making it inefficient on large lists,
     * and generally performs worse than the similar insertion sort.
     * Average performance	O(n^2).
     */
    public void selectionSort() {
        for (int x = 0; x < arraySize; x++) {
            int minimum = x;
            for (int y = x; y < arraySize; y++) {
                if (theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValue(x, minimum);
        }
    }

    /**
     * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
     * It is much less efficient on large lists than more advanced algorithms such as quicksort , heapsort, or merge sort.
     * Average performance	O(n^2).
     */
    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while ((j > 0) && (theArray[j - 1] > toInsert)) {
                theArray[j] = theArray[j - 1];
                j--;
            }
            theArray[j] = toInsert;
        }
    }

    /**
     * Shellsort, also known as Shell sort or Shell's method, is an in-place comparison sort.
     * It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort).
     * Average performance depends on gap sequence.
     * Best-case performance O(n log n).
     */
    public void shellSort() {
        int inner, outer, temp;
        int interval = 1;

        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (outer = interval; outer < arraySize; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > interval - 1 && theArray[inner - interval] >= temp) {
                    theArray[inner] = theArray[inner - interval];
                    inner -= interval;
                }
                theArray[inner] = temp;
            }
            interval = (interval - 1) / 3;
        }
    }


    /**
     * This method just partition the array for the quick sort.
     * @param left represent the left pointer.
     * @param right represent the right pointer.
     * @param pivot represent the pivot , we need the pivot in order to partition the array.
     * @return the left pointer an this is the pivot location.
     */
    public int partitionArray(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (theArray[++leftPointer] < pivot)
                ;
            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swapValue(leftPointer, rightPointer);
            }
        }
        swapValue(leftPointer, right);
        return leftPointer;
    }

    /**
     * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm,
     * serving as a systematic method for placing the elements of an array in order.
     * Developed by Tony Hoare in 1959, with his work published in 1961, it is still a commonly used algorithm for sorting.
     * When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort.
     * Average performance O(n log n).
     * @param left the left limit.
     * @param right the right limit.
     */
    public void quickSort(int left, int right) {
        if (right - left <= 0){
            return;
        }else{
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left,right,pivot);

            quickSort(pivotLocation+1,right);
            quickSort(left,pivotLocation-1);
        }
    }


    public static void main(String[] args) {
        ArrayStructures array = new ArrayStructures(10);

        array.displayArray();
        //array.bubbleSort();
        //array.selectionSort();
        //array.insertionSort();
        //array.shellSort();
        array.quickSort(0,9);
        array.displayArray();


    }
}
