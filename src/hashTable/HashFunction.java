package hashTable;


import java.util.Arrays;

/**
 * If we think of a Hash Table as an array
 * then a hash function is used to generate
 * a unique key for every item in the array.
 * The position the item goes in is known
 * as the slot. Hashing doesn't work very well
 * in situations in which duplicate data
 * is stored. Also it isn't good for searching
 * for anything except a specific key.
 * However a Hash Table is a data structure that
 * offers fast insertion and searching capabilities.
 */
public class HashFunction {

    private String[] theArray;
    private int arraySize;


    public HashFunction(int size) {
        arraySize = size;
        theArray = new String[arraySize];
        Arrays.fill(theArray, "-1");
    }


    public static void main(String[] args) {
        HashFunction theFunc = new HashFunction(30);
        String[] elementsToAdd = {"3","21","15","4","25","11","7"};
        String[] elementsToAdd2 = { "218", "210", "170", "214", "268", "317",
                "235", "809", "900", "723", "678", "1", "16", "999", "890",
                "320", "998", "978", "754", "990", "640", "984", "320", "321",
                "400", "415", "379", "50", "660", "624" };
        //theFunc.hashFunctionOne(elementsToAdd,theFunc.theArray);
        theFunc.hashFunctionTwo(elementsToAdd2,theFunc.theArray);
        theFunc.display();
        System.out.println(theFunc.findKey("640"));

    }


    /**
     * This method display the array.
     */
    public void display() {
        int increment = 0;

        for (int m = 0; m < 3; m++) {
            increment += 10;

            for (int i = increment - 10; i < increment; i++) {
                System.out.format("| %3s " + " ", i);
            }
            System.out.println("|");

            for (int i = increment - 10; i < increment; i++) {
                if (theArray[i].equals("-1")) System.out.print("|      ");
                else System.out.print(String.format("| %3s " + " ", theArray[i]));
            }
            System.out.println("|");
            System.out.println();
        }
    }


    /**
     * This method is a simple hash function that
     * puts values in the same index that matches their value.
     * @param stringForArray represent the elements that we want to add.
     * @param theArray represent the array were we want to store.
     */
    public void hashFunctionOne(String[] stringForArray, String[] theArray) {

        for (int i = 0; i < stringForArray.length; i++) {
            String newElement = stringForArray[i];
            theArray[Integer.parseInt(newElement)] = newElement;
        }
    }


    /**
     * Now let's say we have to hold values between 0 & 999
     * but we never plan to have more than 15 values in all.
     * One way to fit these numbers into a 30 item array is
     * to use the mod function. All you do is take the modulus
     * of the value versus the array size.
     * The goal is to make the array big enough to avoid
     * collisions, but not so big that we waste memory.
     * @param stringForArray represent the elements that we want to add.
     * @param theArray represent the array were we want to store.
     */
    public void hashFunctionTwo(String[] stringForArray, String[] theArray) {

        for (int i = 0; i < stringForArray.length; i++) {
            String newElement = stringForArray[i];
            // Create an index to store the value in by taking
            // the modulus
            int indexValue = Integer.parseInt(newElement) % 29;

            // Cycle through the array until we find an empty space
            while (theArray[indexValue] != "-1") {
                ++indexValue;
                // If we get to the end of the array go back to index 0
                indexValue %= arraySize;
            }
            theArray[indexValue] = newElement;
        }
    }


    /**
     * This method returns the value stored in the hash table at a certain key.
     * @param key the key we want to find.
     * @return the value found at that certain key.
     */
    public String findKey(String key) {

        // Find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key) % 29;
        int counter = 0;
        String notFound = "The key was not found";

        while (theArray[arrayIndexHash] != "-1" && counter < theArray.length){
            if (theArray[arrayIndexHash] == key){
                // Found the key so return it
                System.out.println(key+" was found at index "+arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            // Look in the next index
            ++arrayIndexHash;
            // If we get to the end of the array go back to index 0
            arrayIndexHash %= arraySize;
            counter++;
        }
        // Couldn't locate the key
        return notFound;
    }


}
