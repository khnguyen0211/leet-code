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

    /**A ramp in an integer array arr is a pair (i, j) for which i < j and arr[i] <= arr[j].
     * The width of such a ramp is j - i.
     *
     * @param arr : an integer array
     * @return ramp array length
     */
     int p962_max_width_ramp(int[] arr);
}
