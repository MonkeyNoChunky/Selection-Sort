import java.util.Scanner; 


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Creates a new scan object 
        System.out.println("Please input number of values");
        int arrayLength = scan.nextInt(); // Recieves an interager value from the user which determins the length of the array
        int[] array = new int[arrayLength]; // Creates a new array with the length of arrayLength which was inputted by the user
        System.out.println("Do you want to manually add the values, or have the randomly generated?\n[1] Manual Edit\n[2] Automatic generator"); 
        int choice = scan.nextInt(); // Recieves the input number from the user to understand their choice, must be an integer
        if(choice == 1) { // If the users inputed choice equals 1 then it proceeds to allow the user to input manual values into the array to be sorted
            for (int i = 0; i < arrayLength; i++) { // A for-loop which asks the user for a value a number of times which is equal to the arrayLength variable and adds it into the unsorted array 
            System.out.println("Please insert your " + (i + 1) + " value"); 
            array[i] = scan.nextInt(); // Assigns the next interger value inputed by the user to the value of which the for loop is on
            } 
        } else { // If the users inputed choice does not equal to 1(allows for any other number to limit edge cases) then it proceeds to generate numbers to be sorted
            createRandomInputNumbers(array); // Adds a list of randomized numbers from 0-1000 to the array. The number of values change with the array length 
        }
        printArray(array); // Calls the printArray method to print out the full unsorted array 
        selectionSort(array); // Calls the selectionSort method to sort the inputed array using the selection sort algorithm
        System.out.println(); //- *Note, Owen do we have a reason for this line? 
        printArray(array); // Calls the printArray method to print the sorted array list to the terminal
    }



    public static void swap(int index1, int index2, int[] array) { // This method swaps the current value 
        int placeHolder = array[index1]; // Sets an integer placeholder variable to the array value which is held in an inputed value of index1
        array[index1] = array[index2]; // Sets the value at "index1" to be the value at index2(the smaller number)
        array[index2] = placeHolder; // Sets the old value at the position of index 2 to be the placeHolder variable that was stored
    }


    static void selectionSort(int[] array) { // This method sorts the inputted array using the selection sort algorithm
        int lowestNumIndex; // Variable to store the lowest numbers position in a range 
        for(int i = 0; i < array.length - 1; i++) { // A For-Loop to increment through each value in the array 
            lowestNumIndex = i; // Sets the position where the next lowest number will go to be i 
            for(int o = i + 1; o < array.length; o++) { // Increments through a selected range, which is the value of the previous for loop plus one, so it will always check a smaller range as it proceeds
                if(array[o] < array[lowestNumIndex]) { // Proceeds if the value at the current index of the array is lower than the current lowest number checked in that range
                    lowestNumIndex = o; // Sets the lowestNumIndex value to be the value of the current index being checked in the range
                }
            }
            swap(i, lowestNumIndex, array); // Calls the swap method to swap the current lowest number in a range with the number located at the lowest index in the range
        }
    }

    static void printArray(int[] array) { // This method prints out the values of the array
        for(int i : array) { // Advanced for-loop to cycle through each value in the inputed array to print it out to the console
            System.out.print(i + " ");
        }
    }


    public static void createRandomInputNumbers(int[] array) { // This method generates random numbers to be sorted
        for(int i = 0; i < array.length; i++) {  // For-loop to increment through each position in the inputed array
            array[i] = (int) ((Math.random() + 1) * 1000); // Assigns the current position in the array to be a random number between 1 and 1000
        }
    }
}