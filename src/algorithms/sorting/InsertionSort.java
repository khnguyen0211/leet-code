package algorithms.sorting;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0) {
                if(arr[j] > value){
                    arr[j + 1] = arr[j];
                    j--;
                } else  {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 8, 1, 2};
        insertionSort(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
