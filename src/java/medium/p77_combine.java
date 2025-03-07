package java.medium;

import java.util.ArrayList;
import java.util.List;

public class p77_combine {
    public static List<List<Integer>> combine(int n, int k) {
        int[] selections = new int[k];
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, numbers, selections, results);
        return results;
    }

    public static void backtrack(int currentIndex, int[] numbers, int[] selections,
            List<List<Integer>> results) {
        for (int i = 0; i < numbers.length; i++) {
            if (currentIndex > 0) {
                if (numbers[i] > selections[currentIndex - 1]) {
                    selections[currentIndex] = numbers[i];
                    if (currentIndex == selections.length - 1) {
                        handleSelection(selections, results);
                    } else {
                        backtrack(currentIndex + 1, numbers, selections, results);
                    }
                }
            } else {
                selections[currentIndex] = numbers[i];
                if (currentIndex == selections.length - 1) {
                    handleSelection(selections, results);
                } else {
                    backtrack(currentIndex + 1, numbers, selections, results);
                }
            }

        }
    }

    private static void handleSelection(int[] selections, List<List<Integer>> results) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < selections.length; i++) {
            result.add(selections[i]);
        }
        results.add(result);
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
