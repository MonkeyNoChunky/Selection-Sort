import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input the number of values in the list");
        int arrayLength = scan.nextInt(); // User input determining the array length
        int[] array = new int[arrayLength];  // Declears and initiates an array with the user-inputed length
        System.out.println("How would you like to assign values?\n[1] Manual Edit\n[2] Automatic generator");

        if(scan.nextInt() == 1) { 
            // Allows the user to input set individual values to the array
            for (int i = 0; i < arrayLength; i++) { // iterating through each index
                System.out.println("Please insert your " + (i + 1) + " value");
                array[i] = scan.nextInt();
            }
        } else { // any possible number to limit edge cases
            generateRandomNumbers(array); // fills array with random values from 0-999
        }

        printArray(array);
        selectionSort(array);
        printArray(array);
    }

    // Swaps the values of two elements of an array
    static void swap(int index1, int index2, int[] array) {
        int placeHolder = array[index1];
        array[index1] = array[index2]; 
        array[index2] = placeHolder; 
    }

    // Sorts an array using Selection sort logic
    // Repeatedly finds the smallest remaining element and swaps with the current index (i)
    static void selectionSort(int[] array) {
        int lowestNumIndex; // Index of the smallest number in the current pass
        for(int i = 0; i < array.length - 1; i++) { // Stops at length-1 because the last number is automatically sorted
            lowestNumIndex = i; // Assume the current index holds the smallest value
            for(int j = i + 1; j < array.length; j++) { // Starts at index+1 to compare next number
                if(array[j] < array[lowestNumIndex]) {
                    lowestNumIndex = j; // Assigning lowestNumIndex to a new lowest index found
                }
            }
            swap(i, lowestNumIndex, array); // Swaps the current lowest number in a range with the number located at the lowest index in the range 
        }
    }

    // Prints all elements of an array through iteration, separated by a space
    static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(); // Formatting line
    }

     // Generates random numbers to be sorted, picks a value between 0 and 999 for each value
    static void generateRandomNumbers(int[] array) { 
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); // Possible values of 0 to 999
        }
    }
}








