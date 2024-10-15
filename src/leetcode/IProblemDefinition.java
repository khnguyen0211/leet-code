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

    /**
     *
     * @param n
     * @return
     */
    int p1137_tribonacci(int n);

    /**
     * Given an integer n, return an array has length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     * @param n
     * @return
     */
    int[] p338_count_bits(int n);

    /**
     * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
     * Once you pay the cost, you can either climb one or two steps.
     * @param cost array
     * @return min cost to reach the top
     */
    int p746_min_cost_climbing_stairs(int[] cost);

    int p1025_divisor_game(int n);

    /**
     *
     * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
     * The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
     * If word is not a substring of sequence, word's maximum k-repeating value is 0.
     * @return maximum repeating of word in sequence
     */
    int p1668_maximum_repeating_substring(String sequence, String word);

    /**
     *
     * @param s
     * @return
     */
    long p2938_minimum_steps(String s);

    /**
     *
     * @param arr
     * @return
     */
    boolean p217_contains_duplicate(int[] arr);
}

