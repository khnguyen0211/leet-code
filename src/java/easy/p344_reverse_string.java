package java.easy;

public class p344_reverse_string {

    /*
     * Runtime 0 ms Beats 100.00%
     */
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
