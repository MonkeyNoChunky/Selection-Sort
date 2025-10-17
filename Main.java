import java.util.Scanner; 


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input number of values");
        int arrayLength = scan.nextInt(); 
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Please insert your " + (i + 1) + " value"); 
            array[i] = scan.nextInt(); 
        }

        printArray(array);
        selectionSort(array);
        System.out.println();
        printArray(array); 
    }


    public static void swap(int index1, int index2, int[] array) {
        int placeHolder = array[index1];
        array[index1] = array[index2]; 
        array[2] = placeHolder; 
    }


    static void selectionSort(int[] array) {
        int lowestNum = 0; 
        int lowestNumIndex = 0; 
        for(int i = 0; i < array.length - 1; i++) {
            for(int o = i + 1; o < array.length; o++) {
                lowestNumIndex = o;
                lowestNum = array[i];
                if(array[o] < lowestNum) {
                    lowestNum = array[o];
                }
            }
            swap(i, lowestNumIndex, array);
        }
    }

    static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
    }
}