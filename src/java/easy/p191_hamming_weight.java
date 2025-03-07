package java.easy;

public class p191_hamming_weight {
    /*
     * Runtime 0 ms Beats 100.00%
     */
    public static int hamming_weight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        hamming_weight(11);
    }
}
