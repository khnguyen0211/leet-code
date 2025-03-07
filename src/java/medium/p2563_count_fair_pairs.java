package java.medium;

import java.util.Arrays;

public class p2563_count_fair_pairs {
    /*
     * lower_bound Time Limit Exceeded
     */
    public static long count_fair_pairs_v1(int[] arr, int lower, int upper) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] >= lower && arr[i] + arr[j] <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long count_fair_pairs_v2(int[] arr, int lower, int upper) {
        Arrays.sort(arr);
        return lower_bound(arr, upper + 1) - lower_bound(arr, lower);
    }

    public static long lower_bound(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        long result = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < value) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
