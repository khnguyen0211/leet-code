package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class p3211_valid_strings {

    public static List<String> valid_strings(int n) {
        List<String> results = new ArrayList<>();
        int[] selections = new int[n];
        int[] validValues = new int[] {0, 1};
        backtrack(0, selections, validValues, results);
        return results;
    }

    public static void backtrack(int currentIndex, int[] selections, int[] validValues,
            List<String> results) {
        for (int i = 0; i < validValues.length; i++) {
            selections[currentIndex] = validValues[i];
            if (currentIndex == selections.length - 1) {
                handleSelections(selections, results);
            } else {
                backtrack(currentIndex + 1, selections, validValues, results);
            }
        }
    }

    private static void handleSelections(int[] a, List<String> results) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1 && a[i] == 0 && a[i + 1] == 0) {
                return;
            }
            sb.append(a[i]);

        }
        results.add(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(valid_strings(3));
    }
}
