package leetcode.medium;

public class p59_generate_matrix {
    /*
     * Runtime 0 ms Beats 100.00%
     */
    public static int[][] p59_generate_matrix(int n) {
        int[][] matrix = new int[n][n];
        int loops = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        int current_value = 1;
        for (int i = 0; i < loops; i++) {
            current_value = fill_left_to_right(matrix, i, i, n - 1 - i, current_value);
            current_value = fill_top_to_bot(matrix, n - 1 - i, i + 1, n - 1 - i, current_value);
            current_value = fill_right_to_left(matrix, n - 1 - i, n - 2 - i, i, current_value);
            current_value = fill_bot_to_top(matrix, i, n - 2 - i, i + 1, current_value);
        }
        return matrix;
    }

    public static int fill_left_to_right(int[][] matrix, int i, int from, int to, int value) {
        for (int j = from; j <= to; j++) {
            matrix[i][j] = value;
            value++;
        }
        return value;
    }

    public static int fill_right_to_left(int[][] matrix, int i, int from, int to, int value) {
        for (int j = from; j >= to; j--) {
            matrix[i][j] = value;
            value++;
        }
        return value;
    }

    public static int fill_top_to_bot(int[][] matrix, int j, int from, int to, int value) {
        for (int i = from; i <= to; i++) {
            matrix[i][j] = value;
            value++;
        }
        return value;
    }

    public static int fill_bot_to_top(int[][] matrix, int j, int from, int to, int value) {
        for (int i = from; i >= to; i--) {
            matrix[i][j] = value;
            value++;
        }
        return value;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] rs = p59_generate_matrix(1);
        printMatrix(rs);
    }
}
