import java.util.Scanner; 


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input number of values");
        int arrayLength = scan.nextInt(); 
        int[] array = new int[arrayLength]; // Creates a new array with the length of arrayLength, which was inputted by the user
        System.out.println("Do you want to manually add the values, or have the randomly generated?\n[1] Manual Edit\n[2] Automatic generator"); 
        int choice = scan.nextInt(); //Receives the input number from the user to understand their choice, must be an integer
        if(choice == 1) { // If the user inputs 1 
            for (int i = 0; i < arrayLength; i++) { // A for-loop which asks the user for a value a number of times, which is equal to the arrayLength variable, and adds it to the unsorted array 
            System.out.println("Please insert your " + (i + 1) + " value"); 
            array[i] = scan.nextInt(); 
            } 
        } else { // If number does not equal to 1(limits edge cases) 
            createRandomInputNumbers(array); // Adds a list of randomized numbers from 0-1000 to the array. The number of values changes with the array length 
        }
        printArray(array); // Calls the printArray method to print out the full unsorted array 
        selectionSort(array); // Calls the sort algorithm
        printArray(array);
    }



    public static void swap(int index1, int index2, int[] array) { // Method to swap 2 number's positions in an array
        int placeHolder = array[index1];
        array[index1] = array[index2];
        array[index2] = placeHolder; 
    }


    static void selectionSort(int[] array) { // Sorts the inputted array using the selection sort algorithm
        int lowestNumIndex; // Variable to store the lowest number's position in a range 
        for(int i = 0; i < array.length - 1; i++) {
            lowestNumIndex = i; // Sets the position where the next lowest number will go to be i 
            for(int o = i + 1; o < array.length; o++) { // Increments through a selected range, which is the value of the previous for loop plus one, so it will always check a smaller range as it proceeds
                if(array[o] < array[lowestNumIndex]) { // Cbecks if the current index is smaller then the lowest number in the range
                    lowestNumIndex = o; // Sets the lowestNumIndex value to be the value of the current index being checked in the range
                }
            }
            swap(i, lowestNumIndex, array); // Calls the swap method to swap the current lowest number in a range with the number located at the lowest index in the range
        }
    }

    static void printArray(int[] array) { // This method prints out the values of the array by cycling through each index and printing its value
        for(int i : array) { 
            System.out.print(i + " ");
        }
    }


    public static void createRandomInputNumbers(int[] array) { // This method generates random numbers to be sorted, picks a value between 1 and 1000 for each value
        for(int i = 0; i < array.length; i++) {  
            array[i] = (int) ((Math.random() + 1) * 1000);
        }
    }
}
