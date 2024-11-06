package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class p80_remove_duplicates {
    /*
     * Runtime 4 ms Beats 5.40%
     */
    public static int remove_duplicates(int[] arr) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length - sum;) {
            int frequent = map.get(arr[i]);
            if (frequent <= 2) {
                i += frequent;
                continue;
            }
            int diff = frequent - 2;
            sum += diff;
            for (int j = i + 2; j < arr.length - diff; j++) {
                arr[j] = arr[j + diff];
            }
            i += 2;
        }
        return arr.length - sum;
    }

    public static void main(String[] args) {
        // 111223
        // 112233
        int[] a = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(remove_duplicates(a));
    }
}
