import java.lang.reflect.Array;
import java.util.ArrayList;

public class twentinineth_print_in_clockwise {
    public static void main(String[] args) {
//        System.out.println(printMatrix(new int[][]{{1}}));
//        System.out.println(printMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}}));
        System.out.println(printMatrix(new int[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}
        }));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int index = 0;
//        while (index * 2 < rows && index * 2 < cols) {
        while ((index << 1) < Math.min(rows, cols)) {
            printInCircle(list, matrix, rows, cols, index);
            index++;
        }
        return list;
    }

    private static void printInCircle(ArrayList<Integer> list, int[][] matrix, int rows, int cols, int index) {
        // judge if index out of bound or rows | cols miner than 0
        if (rows <= 0 || cols <= 0) {
            return;
        }

        int endX = cols - 1 - index;
        int endY = rows - 1 - index;
        // from left to right
        for (int i = index; i <= endX; i++) {
            list.add(matrix[index][i]);
        }
        // if print up to down, there must be more than 1 rows(endY - index)>=1
        // from up to down
        if ((endY - index) >= 1) {
            for (int i = index + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        // if print right to left, there must be more than 1 rows(endY - index) >= 1 and more than 1 cols (endX - index) >= 1
        // from right to left
        if ((endY - index) >= 1 && (endX - index) >= 1) {
            for (int i = endX - 1; i >= index; i--) {
                list.add(matrix[endY][i]);
            }
        }
        // if print down to up, there must be more than 2 rows(endY - index)>=2 and more than 1 cols (endX - index) >= 1
        // from down to up
        if ((endY - index) >= 2 && (endX - index) >= 1) {
            for (int i = endY - 1; i > index; i--) {
                list.add(matrix[i][index]);
            }
        }
    }
}