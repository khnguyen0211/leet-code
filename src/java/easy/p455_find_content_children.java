package java.easy;

import java.util.Arrays;


public class p455_find_content_children {
   
    /*
     * Runtime 9 ms Beats 99.68%
     */
    public static int find_content_children(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j < s.length) {
                count++;
                i++;
                j++;
            }

        }
        return count;
    }

    public static void main(String[] args) {

    }
}
