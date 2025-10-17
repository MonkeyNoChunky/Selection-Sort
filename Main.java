import java.util.Scanner; 


public class Main {


       static int[] array; 
    public static void main(String[] args) {

        System.out.println("Please input number of values");

        Scanner scan = new Scanner(System.in);

        int arrayLength = scan.nextInt(); 

        array = new int[arrayLength];


        for (int i = 0; i < arrayLength; i++) {
            
            System.out.println("Please insert your " + i + " value"); 

            array[i] = scan.nextInt(); 

        }


        System.out.println("Unsorted array "  + array.toString()); 

        selectionSort(array);


        System.out.println("Sorted Array: " + array.toString()); 

    }


    public static void swap(int arrayValue, int lowestNum, int lowestNumberPosition, int currentPosition) {

        int placeHolder = arrayValue;

        array[lowestNumberPosition] = lowestNum; 

        array[currentPosition] = placeHolder; 




    }


    static void selectionSort(int[] array) {
        int lowestNum = 0; 
        int currentPosition = 0; 
        for(int i = 0; i < array.length; i++) {
            for(int o = i + 1; o < array.length - 1; o++) {
                currentPosition = o;
                lowestNum = array[i];
                if(array[o] < lowestNum) {
                    lowestNum = array[o];
                }
            }
            swap(array[i], lowestNum, i, currentPosition);
        }
    }


    

}