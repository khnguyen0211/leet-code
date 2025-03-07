package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class p80_remove_duplicates {
    
    /*
     * Runtime 0 ms Beats 100%
     */
    public static int remove_duplicates(int[] arr) {
        int j = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == arr[j - 1] && arr[i] == arr[j - 2]) {
                continue;
            }
            arr[j] = arr[i];
            j++;
        }
        return j;
    }

    /*
     * Runtime 4 ms Beats 5.40%
     */
    public static int remove_duplicates_v1(int[] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length - count;) {
            int frequent = map.get(arr[i]);
            if (frequent <= 2) {
                i += frequent;
                continue;
            }
            int diff = frequent - 2;
            count += diff;
            for (int j = i + 2; j < arr.length - diff; j++) {
                arr[j] = arr[j + diff];
            }
            i += 2;
        }
        return arr.length - count;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(remove_duplicates(a));
    }
}
