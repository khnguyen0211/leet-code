package java.medium;

public class p3254_results_array {
    /*
     * Runtime 2 ms Beats 58.78%
     */
    public static int[] results_array(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                if (arr[j] == max + 1) {
                    max = arr[j];
                } else {
                    max = -1;
                    break;
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
