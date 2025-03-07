package java.medium;

public class p1829_get_maximum_xor {
    /*
     * Runtime 3 ms Beats 78.95%
     */
    public static int[] get_maximum_xor(int[] arr, int maximumBit) {
        int max_xor = (int) Math.pow(2, maximumBit) - 1;
        int n = arr.length;
        int[] res = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            res[n - 1 - i] = xor ^ max_xor;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 4, 7};
        for (int i : get_maximum_xor(a, 34)) {
            System.out.println(i);
        }
    }
}
