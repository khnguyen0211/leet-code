package leetcode.medium;

public class p1476_SubRectangleQueries {
    private final int[][] rectangle;

    public p1476_SubRectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubRectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}
