package leetcode.medium;

public class p75_sort_colors {
    /*
     * DNF (Dutch National Flag) Algorithm 
     * Runtime 0 ms Beats 100.00%
     * 
     */
    public static void sort_colors_v2(int[] colors) {
        int low = 0;
        int high = colors.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (colors[mid]) {
                case 0 -> {
                    int temp = colors[low];
                    colors[low] = colors[mid];
                    colors[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> {
                    mid++;
                }
                case 2 -> {
                    int temp2 = colors[mid];
                    colors[mid] = colors[high];
                    colors[high] = temp2;
                    high--;
                }
                default -> throw new AssertionError();
            }
        }
    }

    /*
     * Runtime: 1ms, Beats: 22.31%
     */
    public static void sort_colors_v1(int[] colors) {
        for (int i = 1; i < colors.length; i++) {
            int j = i - 1;
            int color = colors[i];
            while (j >= 0 && colors[j] > color) {
                colors[j + 1] = colors[j];
                j--;
            }
            colors[j + 1] = color;
        }
    }

    public static void main(String[] args) {
        int[] colors = new int[] {0, 1, 2, 1, 0, 2, 2,0, 1, 0, 0, 2};
        sort_colors_v2(colors);
        for (int color : colors) {
            System.out.println(color);
        }
    }
}
