package leetcode;

public interface IProblemDefinition {
    /**
     * Given a string s, find the first non-repeating character in it and return its index.
     * If it does not exist, return -1.
     * @param s is a string
     * @return int
     */
    int p387_first_unique_char(String s);

    /**
     *Given an integer array arr, return the third distinct maximum number in this array.
     * If the third maximum does not exist, return the maximum number.
     * @param arr is an int array
     * @return index of the third maximum in array
     */
    int p414_the_third_maximum(int[] arr);

    /**
     * A ramp in an integer array arr is a pair (i, j) for which i < j and arr[i] <= arr[j].
     * The width of such a ramp is j - i.
     * @param arr : an integer array
     * @return ramp array length
     */
     int p962_max_width_ramp(int[] arr);


    /**
     * There is a party where n friends numbered from 0 to n - 1 are attending.
     * There is an infinite number of chairs in this party that are numbered from 0 to infinity. W
     * hen a friend arrives at the party, they sit on the unoccupied chair with the smallest number.
     */
    int p1942_smallest_chair(int[][] times, int targetFriend);

    int p1137_tribonacci(int n);

    /**
     * Given an integer n, return an array has length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     * @param n
     * @return
     */
    int[] p338_count_bits(int n);
}
