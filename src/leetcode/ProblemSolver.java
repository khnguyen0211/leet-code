package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class ProblemSolver implements  IProblemDefinition{

    /**
     * runtime: 13 ms
     * beat: 65.92%
     * memory: 45.18 mb
     * beat: 51.11%
     */
    @Override
    public int p387_first_unique_char(String s) {
        char[] arr = s.toCharArray();
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[k] && i != k) {
                k++;
                if(k == arr.length ) {
                    return -1;
                }
                i = -1;
            }
        }
        return k;
    }

    /**
     * runtime: 4 ms
     * beat: 99.08%
     * memory: 44.99 mb
     * beat: 82.21%
     */
    public int p387_firstUniqueChar_v2(String s) {
        int[] counters = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            /*
              c = 'a' -> counters[0]
              c = 'b' -> counters[1]
              ...
             */
            counters[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(counters[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * runtime: 1 ms
     * beat: 96.72%
     * memory: 43.32 mb
     * beat: 40.36%
     */
    @Override
    public int p414_the_third_maximum(int[] arr) {
        long[] arrMax = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int j : arr) {
            insertIntoArray(arrMax, j);
        }
        if(arrMax[2] == Long.MIN_VALUE) {
            return (int)arrMax[0];
        }
        return (int)arrMax[2];
    }

    public void insertIntoArray(long[] arr, int value) {
        int i = 0;
        while (i < arr.length) {
            if(arr[i] == value) {
                return;
            } else if(arr[i] > value) {
                i++;
            } else  {
                break;
            }
        }

        if(i == arr.length) {
            return;
        }
        for (int j = arr.length - 1; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
    }

    @Override
    /**
     * Using brute force algorithm
     * Time Limit Exceeded
     */
    public int p962_max_width_ramp(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < n - max; i++) {
            for (int j = i + max; j < n; j++) {
                if(arr[j] >= arr[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }



    /**
     * Using monotonic stack
     * Time Limit Exceeded
     */
    public int p962_max_width_ramp_v2(int[] arr) {
        int n = arr.length;
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                maxWidth = Math.max(maxWidth, i - stack.peek());
                stack.pop();
            }
        }
        return maxWidth;
    }


    @Override
    /**
     * runtime: 92 ms
     * beat: 14.62%
     * memory: 50.32 mb
     * beat: 42.10%
     */
    public int p1942_smallest_chair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        int n = times.length;
        int[] occupied = new int[n];
        for(int i = 0; i < n; i++) {
            if(times[i][0] > targetTime[0]) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if(times[i][0] >= occupied[j]) {
                    occupied[j] = times[i][1];
                    if (Arrays.equals(times[i], targetTime)) return j;
                    break;
                }
            }
        }
        return 0;
    }
}
