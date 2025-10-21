import java.util.Scanner; 


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input the number of values in the list");
        int arrayLength = scan.nextInt();
        int[] array = new int[arrayLength];
        System.out.println("How would you like to assign values?\n[1] Manual Edit\n[2] Automatic generator");

        if(scan.nextInt() == 1) { 
            for (int i = 0; i < arrayLength; i++) { 
                System.out.println("Please insert your " + (i + 1) + " value"); 
                array[i] = scan.nextInt();
            }
        } else {
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

    // repeatedly finds the smallest remaining element and swaps with the current index (i)
    static void selectionSort(int[] array) {
        int lowestNumIndex; // stores the position of the lowest number found
        for(int i = 0; i < array.length - 1; i++) {
            lowestNumIndex = i; // resetting lowestNumIndex after every selection scan
            for(int o = i + 1; o < array.length; o++) {
                if(array[o] < array[lowestNumIndex]) {
                    lowestNumIndex = o; // assigning lowestNumIndex to a new lowest index found
                }
            }
            swap(i, lowestNumIndex, array); // swapping two elements to sort the array 
        }
    }

    // prints all elements of an array seperated by a space
    static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // assigns random values to an array
    static void generateRandomNumbers(int[] array) { 
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); // possible values of 1 to 1000
        }
    }
}