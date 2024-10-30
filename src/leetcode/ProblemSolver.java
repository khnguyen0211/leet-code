package leetcode;

import java.util.*;
import static java.util.Arrays.sort;

public class ProblemSolver implements IProblemDefinition {

    public ProblemSolver() {}

    @Override
    public int[] p1_two_sum(int[] arr, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = target - arr[i];
            if (myMap.containsKey(x)) {
                return new int[] {i, myMap.get(x)};
            }
            myMap.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }

    /**
     * runtime: 13 ms beat: 65.92% memory: 45.18 mb beat: 51.11%
     */
    @Override
    public int p387_first_unique_char(String s) {
        char[] arr = s.toCharArray();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[k] && i != k) {
                k++;
                if (k == arr.length) {
                    return -1;
                }
                i = -1;
            }
        }
        return k;
    }

    /**
     * runtime: 4 ms beat: 99.08% memory: 44.99 mb beat: 82.21%
     */
    public int p387_firstUniqueChar_v2(String s) {
        int[] counters = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            /*
             * c = 'a' -> counters[0] c = 'b' -> counters[1] ...
             */
            counters[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (counters[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * runtime: 1 ms beat: 96.72% memory: 43.32 mb beat: 40.36%
     */
    @Override
    public int p414_the_third_maximum(int[] arr) {
        long[] arrMax = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int j : arr) {
            insertIntoArray(arrMax, j);
        }
        if (arrMax[2] == Long.MIN_VALUE) {
            return (int) arrMax[0];
        }
        return (int) arrMax[2];
    }

    public void insertIntoArray(long[] arr, int value) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == value) {
                return;
            } else if (arr[i] > value) {
                i++;
            } else {
                break;
            }
        }

        if (i == arr.length) {
            return;
        }
        for (int j = arr.length - 1; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
    }

    /**
     * Using brute force algorithm Time Limit Exceeded
     */
    @Override
    public int p962_max_width_ramp(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n - max; i++) {
            for (int j = i + max; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    /**
     * Using monotonic stack Time Limit Exceeded
     */
    public int p962_max_width_ramp_v2(int[] arr) {
        int n = arr.length;
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
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
     * runtime: 92 ms beat: 14.62% memory: 50.32 mb beat: 42.10%
     */
    @Override
    public int p1942_smallest_chair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        int n = times.length;
        int[] occupied = new int[n];
        for (int i = 0; i < n; i++) {
            if (times[i][0] > targetTime[0]) {
                break;

            }
            for (int j = 0; j < n; j++) {
                if (times[i][0] >= occupied[j]) {
                    occupied[j] = times[i][1];
                    if (Arrays.equals(times[i], targetTime))
                        return j;
                    break;
                }
            }
        }
        return 0;
    }

    /**
     * runtime: 1 ms beat: 100% memory: 44.63 mb beat: 5.74%
     */
    private final int[] tribonacciArray = new int[100];

    @Override
    public int p1137_tribonacci(int n) {
        if (tribonacciArray[n] != 0) {
            return tribonacciArray[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            tribonacciArray[0] = 0;
            tribonacciArray[1] = 1;
            tribonacciArray[2] = 1;
            return 2;
        }
        tribonacciArray[n] =
                p1137_tribonacci(n - 1) + p1137_tribonacci(n - 2) + p1137_tribonacci(n - 3);
        return tribonacciArray[n];
    }

    /**
     * runtime: 2 ms beat: 95.17% memory: 46.78 mb beat: 22.75%
     */
    @Override
    public int[] p338_count_bits(int n) {
        int[] results = new int[n + 1];
        for (int i = 0; i <= n; i++) {
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
     * runtime: 1 ms beat: 60.80% memory: 41.54 mb beat: 67.56%
     */
    @Override
    public int p1668_maximum_repeating_substring(String sequence, String word) {
        int maxRepeating = 0;
        String temp = word;
        if (!sequence.contains(word)) {
            return maxRepeating;
        }
        while (sequence.contains(temp)) {
            maxRepeating++;
            temp += word;

        }
        return maxRepeating;
    }

    public int climbing(int[] arr, int index, int[] cost) {
        if (cost[index] != -1) {
            return cost[index];
        }
        if (index == 0 || index == 1) {
            cost[index] = arr[index];
            return cost[index];
        }
        if (index == arr.length) {
            cost[index] = Math.min(cost[index - 1], cost[index - 2]);
            return cost[index];
        }
        cost[index] = arr[index]
                + Math.min(climbing(arr, index - 1, cost), climbing(arr, index - 2, cost));
        return cost[index];
    }

    /**
     * runtime: 7 ms beat: 100% memory: 45.74 mb beat: 11.83%
     */
    @Override
    public long p2938_minimum_steps(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        long min_step = 0;
        long zero_counter = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                zero_counter++;
            }
            if (chars[i] == '1') {
                min_step += zero_counter;
            }
        }
        return min_step;
    }

    public long p2938_minimum_steps_v2(String s) {
        char[] chars = s.toCharArray();
        long min_step = 0;
        long one_counter = 0;
        for (char c : chars) {
            if (c == '1') {
                one_counter++;
            } else {
                min_step += one_counter;
            }

        }
        return min_step;
    }

    /**
     * runtime: x ms beat: x% memory: x mb beat: x %
     */
    @Override
    public boolean p217_contains_duplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
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

    @Override
    public boolean p219_contains_nearby_duplicate(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && i - map.get(arr[i]) <= k) {
                return true;
            }
            map.put(arr[i], i);
        }

        return false;
    }

    @Override
    public List<String> p2900_get_longest_subsequence(String[] words, int[] groups) {
        List<String> results = new ArrayList<>();
        int n = groups.length;
        results.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                results.add(words[i]);
            }
        }
        return results;
    }

    /**
     * runtime: 46ms beat: 41.16% memory: 43.97mb beat: 78.06 %
     */
    @Override
    public int p300_longest_increasing_subsequence(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                    if (temp[i] > max) {
                        max = temp[i];
                    }
                }
            }
        }
        return max;
    }

    @Override
    public int p670_maximum_swap(int num) {
        // Convert number to string for digit manipulation
        char[] numArr = Integer.toString(num).toCharArray();
        int n = numArr.length;

        // Track the last occurrence of each digit (0-9)
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[numArr[i] - '0'] = i;
        }
        // Traverse the number from left to right
        for (int i = 0; i < n; i++) {
            // Check if we can find a larger digit to swap
            for (int d = 9; d > numArr[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap and return the new number
                    char temp = numArr[i];
                    numArr[i] = numArr[last[d]];
                    numArr[last[d]] = temp;
                    return Integer.parseInt(new String(numArr));
                }
            }
        }
        // Return the original number if no swap occurred
        return num;
    }

    @Override
    public boolean p941_valid_mountain_array(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        for (int i = 1; i < n - 1; i++) {
            boolean check = true;
            // check increasing array before i
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[j + 1]) {
                    check = false;
                    break;
                }
            }
            // check decreasing array before i
            for (int j = i; j < n - 1; j++) {
                if (arr[j] <= arr[j + 1]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return true;
            }
        }
        return false;
    }

    @Override
    public char p1545_find_Kth_Bit(int n, int k) {
        String[] store = new String[n + 1];
        store[1] = "0";
        for (int i = 2; i <= n; i++) {
            store[i] = store[i - 1] + "1" + revert(invert(store[i - 1]));
        }
        return store[n].toCharArray()[k - 1];
    }

    public static String revert(String s) {
        String[] arr = s.split("");
        int n = arr.length;
        String reverted = "";
        for (int i = n - 1; i >= 0; i--) {
            reverted += arr[i];
        }
        return reverted;
    }

    public static String invert(String s) {
        String[] arr = s.split("");
        int n = arr.length;
        String inverted = "";
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("0")) {
                arr[i] = "1";
            } else {
                arr[i] = "0";
            }
            inverted += arr[i];
        }
        return inverted;
    }

    /**
     * runtime: 0 ms beat: 100% memory: 45.68mb beat: 47.28%
     */
    @Override
    public int p704_binary_search(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public int p69_my_sqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Math.round(right);
    }

    /**
     * runtime: 291 ms beat: 5.27% memory: 45.18mb beat: 7.36%
     */
    @Override
    public List<String> p1002_common_chars(String[] words) {
        int minLength = Integer.MAX_VALUE;
        Map<String, Integer> myMap = new HashMap<>();
        List<String> results = new ArrayList<>();
        String target = "";
        for (String str : words) {
            if (str.length() < minLength) {
                minLength = str.length();
                target = str;
            }
        }
        String[] arr = target.split("");
        for (String s : arr) {
            boolean isContainedAll = true;
            int frequency = 1;
            if (myMap.containsKey(s)) {
                frequency = myMap.get(s) + 1;
            }
            for (String word : words) {
                if (!stringCheckerUtil(word, s, frequency)) {
                    isContainedAll = false;
                    break;
                }
            }
            if (isContainedAll) {
                results.add(s);
                myMap.put(s, myMap.containsKey(s) ? myMap.get(s) + 1 : 1);
            }
        }
        return results;
    }

    public boolean stringCheckerUtil(String s, String target, int frequency) {
        String[] arr = s.split("");
        int count = 0;
        for (String elem : arr) {
            if (elem.equals(target)) {
                count++;
            }
        }
        return count >= frequency;
    }

    /**
     * runtime: 12 ms beat: 97.15% memory: 46.46mb beat: 61.62%
     */
    @Override
    public int p561_array_pair_sum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i += 2) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * runtime: ms beat: % memory: mb beat: %
     */
    @Override
    public int p1252_odd_cells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int counter = 0;
        for (int[] i : indices) {
            int addedRow = i[0];
            int addedColumn = i[1];
            increase_matrix(matrix, addedRow, addedColumn);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void increase_matrix(int[][] matrix, int addedRow, int addedColumn) {
        int n = matrix.length;
        int m = matrix[addedRow].length;
        for (int i = 0; i < m; i++) {
            matrix[addedRow][i] += 1;
        }

        for (int i = 0; i < n; i++) {
            matrix[i][addedColumn] += 1;
        }
    }

    /**
     * runtime: 2 ms beat: 97.27% memory: 44.37mb beat: 92.49%
     */
    @Override
    public List<Integer> p2200_find_k_distant_indices(int[] arr, int key, int k) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                for (j = Math.max(i - k, j); j <= Math.min(arr.length - 1, i + k); j++) {
                    results.add(j);
                }
            }
        }
        return results;
    }

    /**
     * runtime: 11 ms beat: 88.15% memory: 43.00mb beat: 56.39%
     */
    @Override
    public String p819_most_common_word(String paragraph, String[] banned) {
        paragraph = paragraph.replace(".", "-");
        paragraph = paragraph.replace(",", "-");
        paragraph = paragraph.replace("!", "-");
        paragraph = paragraph.replace("?", "-");
        paragraph = paragraph.replace(";", "-");
        paragraph = paragraph.replace("'", "-");
        paragraph = paragraph.replace(" ", "-");
        paragraph = paragraph.toLowerCase();
        String[] separatedString = paragraph.split("-");
        Map<String, Integer> myMap = new HashMap<>();
        for (String word : separatedString) {
            if (!word.isEmpty()) {
                boolean isBanned = false;
                for (String bannedWord : banned) {
                    if (word.equals(bannedWord)) {
                        isBanned = true;
                        break;
                    }
                }
                if (!isBanned) {
                    myMap.put(word, myMap.getOrDefault(word, 0) + 1);
                }
            }

        }
        String commonWord = "";
        int mostFrequent = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() > mostFrequent) {
                mostFrequent = entry.getValue();
                commonWord = entry.getKey();
            }
        }
        return commonWord;
    }

    @Override
    public int p2103_count_points(String rings) {
        Map<Integer, Set<String>> myMap = new HashMap<>();
        int counter = 0;
        String[] arr = rings.split("");
        for (int i = 1; i < arr.length; i += 2) {
            Integer rod = Integer.valueOf(arr[i]);
            Set<String> colorsSet = myMap.getOrDefault(rod, new HashSet<>());
            colorsSet.add(arr[i - 1]);
            myMap.put(rod, colorsSet);
        }
        for (Map.Entry<Integer, Set<String>> entry : myMap.entrySet()) {
            if (entry.getValue().size() >= 3) {
                counter++;
            }
        }
        return counter;
    }

    public int p2103_count_points_v2(String rings) {
        // B0B6G0R6R0R6G9
        int n = rings.length();
        String[] arr = rings.split("");
        Set<Integer> rods = new HashSet<>();
        for (int i = 1; i < n; i += 2) {
            rods.add(Integer.valueOf(arr[i]));
        }
        int counter = 0;
        for (Integer rod : rods) {
            Set<String> colors = new HashSet<>();
            for (int i = 0; i < arr.length; i += 2) {
                if (Objects.equals(Integer.valueOf(arr[i + 1]), rod)) {
                    colors.add(arr[i]);
                }
            }
            if (colors.size() == 3) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int p121_max_profit_first(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    @Override
    public int p122_max_profit_second(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


    /**
     * runtime: 2 ms beat: 99.13% memory: 53.13mb beat: 20.13%
     */
    @Override
    public int p11_max_area(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxValue = 0;
        while (i <= j) {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            if (height * width > maxValue) {
                maxValue = height * width;
            }
            while (i <= j && heights[i] <= height) {
                i++;
            }
            while (i <= j && heights[j] <= height) {
                j--;
            }
        }
        return maxValue;
    }

    /**
     * runtime: 16 ms beat: 96.13% memory: 54.68mb beat: 74.76%
     */
    @Override
    public int p881_num_rescue_boats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        int abandon = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                boats++;
            } else {
                while (i <= j && people[j] > limit - people[i]) {
                    abandon++;
                    j--;
                }
            }
        }
        return boats + abandon;
    }

    /**
     * runtime: 0 ms beat: 100% memory: 41.40mb beat: 88.66%
     */
    @Override
    public List<String> p228_summary_ranges(int[] arr) {
        int i = 0;
        int j = 0;
        List<String> results = new ArrayList<>();
        while (i < arr.length && j < arr.length) {
            StringBuilder s = new StringBuilder();
            s.append(arr[i]);
            j = i + 1;
            boolean flag = false;
            while (j < arr.length && arr[i] + 1 == arr[j]) {
                flag = true;
                i++;
                j++;
            }
            if (flag) {
                s.append("->").append(arr[j - 1]);
            }
            results.add(s.toString());
            i++;
        }
        return results;
    }

    @Override
    public int p268_missing_number(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        while (arr[i] + 1 == arr[i + 1]) {
            i++;
        }
        return arr[i] + 1;
    }

    @Override
    public int p136_single_number(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return n == 1 ? arr[0] : arr[n - 1];
    }

    /**
     * runtime: 0 ms beat: 100% memory: 40.19mb beat: 96.42%
     */
    @Override
    public boolean p202_is_happy_number(int n) {
        int countHandler = 0;
        while (countHandler < 7 && calculate_happy_number(n) != 1) {
            n = calculate_happy_number(n);
            countHandler++;
        }
        return !(countHandler == 7);
    }

    public int calculate_happy_number(int n) {
        if (n % 10 == n) {
            return n * n;
        }
        return (int) Math.pow((n % 10), 2) + calculate_happy_number(n / 10);
    }
}
