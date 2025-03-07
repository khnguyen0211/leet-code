package leetcode.easy;

public class p58_length_of_last_word {

    /*
     * Runtime 0 ms Beats 100%
     */
    public static int length_of_last_word(String s) {
        s = s.trim();
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return n - i - 1;
    }

    /*
     * Runtime 2 ms Beats 11.61%
     */
    public static int length_of_last_word_v2(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        return arr[arr.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(length_of_last_word("abc"));
    }
}
