package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static java.util.Arrays.sort;

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

    /**
     * Using brute force algorithm
     * Time Limit Exceeded
     */
    @Override
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


    /**
     * runtime: 92 ms
     * beat: 14.62%
     * memory: 50.32 mb
     * beat: 42.10%
     */
    @Override
    public int p1942_smallest_chair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        sort(times, (a, b) -> Integer.compare(a[0], b[0]));
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

    /**
     * runtime: 1 ms
     * beat: 100%
     * memory: 44.63 mb
     * beat: 5.74%
     */
    private final int[] arr = new int[100];
    @Override
    public int p1137_tribonacci(int n) {
        if(arr[n] != 0) {
            return arr[n];
        }
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if(n == 3) {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 1;
            return 2;
        }
        arr[n] = p1137_tribonacci(n - 1) + p1137_tribonacci(n - 2) + p1137_tribonacci(n - 3);
        return arr[n];
    }

    /**
     * runtime: 2 ms
     * beat: 95.17%
     * memory: 46.78 mb
     * beat: 22.75%
     */
    @Override
    public int[] p338_count_bits(int n) {
        int[] results = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            results[i] = Integer.bitCount(i);
        }
        return results;
    }

    @Override
    public int p746_min_cost_climbing_stairs(int[] arr) {
        int n = arr.length;
        int[] cost = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            cost[i] = -1;
        }
        return climbing(arr, n, cost);
    }

    @Override
    public int p1025_divisor_game(int n) {
        return n % 2;
    }


    /**
     * runtime: 1 ms
     * beat: 60.80%
     * memory: 41.54 mb
     * beat: 67.56%
     */
    @Override
    public int p1668_maximum_repeating_substring(String sequence, String word) {
        int maxRepeating = 0;
        String temp = word;
        if(!sequence.contains(word)) {
            return maxRepeating;
        }
        while(sequence.contains(temp)) {
            maxRepeating++;
            temp += word;

        }
        return maxRepeating;
    }

    public int climbing(int[] arr, int index, int[] cost) {
        if(cost[index] != -1) {
            return cost[index];
        }
        if(index == 0 || index == 1) {
            cost[index] = arr[index];
            return cost[index];
        }
        if(index == arr.length) {
            cost[index]  =  Math.min(cost[index -1],  cost[index -2 ]);
            return cost[index];
        }
        cost[index] = arr[index] + Math.min(climbing(arr, index - 1, cost), climbing(arr, index - 2, cost));
        return cost[index];
    }

    /**
     * runtime: 7 ms
     * beat: 100%
     * memory: 45.74 mb
     * beat: 11.83%
     */
    @Override
    public long p2938_minimum_steps(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        long min_step = 0;
        long zero_counter = 0;
        for (int i = n - 1; i >=0 ; i--) {
            if(chars[i] == '0') {
                zero_counter++;
            }
            if(chars[i] == '1') {
                min_step += zero_counter;
            }
        }
        return min_step;
    }

    public long p2938_minimum_steps_v2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        long min_step = 0;
        long one_counter = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                one_counter++;
            } else {
                min_step += one_counter;
            }

        }
        return min_step;
    }

    /**
     * runtime: x ms
     * beat: x%
     * memory: x mb
     * beat: x %
     */
    @Override
    public boolean p217_contains_duplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                return  true;
            }
        }
        return false;
    }

    public boolean p217_contains_duplicate_v2(int[] arr) {
        Set<Integer> setNumber = new HashSet<>();
        for (int i : arr) {
            setNumber.add(i);
        }
        return setNumber.size() != arr.length;
    }
}
