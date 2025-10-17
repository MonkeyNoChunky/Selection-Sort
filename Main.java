public class Main {
    public static void main(String[] args) {
        int[] array = new int[50];
    }

    static void selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int o = i + 1; o < array.length; o++) {
                int lowestNum = array[i];
                if(array[o] < lowestNum) {
                    lowestNum = array[o];
                }
            }
            swap(array[i], lowestNum);
        }
    }
}