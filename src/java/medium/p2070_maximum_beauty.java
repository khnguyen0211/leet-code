package java.medium;

import java.util.Arrays;

public class p2070_maximum_beauty {
    /*
     * Runtime 30 ms Beats 100%
     */
    public static int[] maximum_beauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
        int[] rs = new int[queries.length];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = find_item_by_price(items, queries[i]);
        }
        return rs;
    }

    public static int find_item_by_price(int[][] sorted_items, int price) {
        for (int i = sorted_items.length - 1; i >= 0; i--) {
            if (sorted_items[i][0] <= price) {
                return sorted_items[i][1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries = {1, 2, 3, 4, 5, 6};
        maximum_beauty(items, queries);
    }
}
