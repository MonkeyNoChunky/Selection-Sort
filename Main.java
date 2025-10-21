import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input the number of values in the list");
        int arrayLength = scan.nextInt(); // user input determining the array length
        int[] array = new int[arrayLength]; // create an array from the length specified
        System.out.println("How would you like to assign values?\n[1] Manual Edit\n[2] Automatic generator");

        if(scan.nextInt() == 1) { 
            // allows the user to input set individual values to the array
            for (int i = 0; i < arrayLength; i++) { // iterating through each index
                System.out.println("Please insert your " + (i + 1) + " value");
                array[i] = scan.nextInt();
            }
        } else {
            // user wants random numbers to be generated
            generateRandomNumbers(array);
        }

        printArray(array);
        selectionSort(array);
        printArray(array);
    }

    // swaps the values of two elements of an array
    static void swap(int index1, int index2, int[] array) {
        int placeHolder = array[index1];
        array[index1] = array[index2]; 
        array[index2] = placeHolder; 
    }

    // sorts an array using Selection sort logic
    // repeatedly finds the smallest remaining element and swaps with the current index (i)
    static void selectionSort(int[] array) {
        int lowestNumIndex; // index of the smallest number in the current pass
        for(int i = 0; i < array.length - 1; i++) { // stops at length-1 because the last number is automatically sorted
            lowestNumIndex = i; // assume the current index holds the smallest value
            for(int j = i + 1; j < array.length; j++) { // starts at index+1 to compare next number
                if(array[j] < array[lowestNumIndex]) {
                    lowestNumIndex = j; // assigning lowestNumIndex to a new lowest index found
                }
            }
            swap(i, lowestNumIndex, array); // swapping the smallest number and current index 
        }
    }

    // prints all elements of an array seperated by a space
    static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(); // formatting line
    }

    // assigns random values to an array
    static void generateRandomNumbers(int[] array) { 
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); // possible values of 0 to 999
        }
    }
}