package java.medium;

public class p3011_can_sort_array {

    /*
     * Runtime 2 ms Beats 60%
     */
    public static boolean can_sort_array(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                if (Integer.bitCount(arr[j]) == Integer.bitCount(arr[j + 1])) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    return false;
                }
            }
            arr[j + 1] = key;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[] {8, 4, 2, 30, 15};
        can_sort_array(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
