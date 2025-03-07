package java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p46_permute {

    /*
     * Beats 7.76%
     */
    public static List<List<Integer>> permute(int[] arr) {
        Integer[] selections = new Integer[arr.length];
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, arr, selections, results);
        return results;
    }

    public static void backtrack(int currentIndex, int[] arr, Integer[] selections,
            List<List<Integer>> results) {
        for (int i = 0; i < arr.length; i++) {
            selections[currentIndex] = arr[i];
            if (currentIndex == arr.length - 1) {
                if (is_distinct_array(selections)) {
                    List<Integer> rs = new ArrayList<>();
                    rs.addAll(Arrays.asList(selections));
                    results.add(rs);
                }
            } else {
                backtrack(currentIndex + 1, arr, selections, results);
            }
        }
    }

    public static boolean is_distinct_array(Integer[] arr) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(arr));
        return set.size() == arr.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        System.out.println(permute(arr));
    }
}
