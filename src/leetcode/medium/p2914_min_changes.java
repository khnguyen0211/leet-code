package leetcode.medium;

public class p2914_min_changes {
    /*
     * Runtime 3 ms Beats 97.78%
     */
    public static int min_changes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
