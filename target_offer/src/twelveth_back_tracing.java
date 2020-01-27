public class twelveth_back_tracing {
    // this algorithm is a little bit complicated
    // cause i've done some debug before found my parameter mistakes
    public static boolean[][] visited;
    public static void main(String[] args) {
        findPathInOneDimension();
//        findPathInTwoDimension();
    }

    private static void findPathInOneDimension() {
        String input = "ABCESFCSADEE";
        char[] matrix = input.toCharArray();
        // "ABCESFCSADEE",3,4,"ABCCED"

        String output = "ABCCED";
        char[] str = output.toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    private static boolean[] visitedFlag;
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visitedFlag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existPath(matrix, i, j, rows, cols, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existPath(char[] matrix, int row, int col, int rows, int cols, char[] str, int index) {
        if (row < 0 || rows <= 0 || col < 0 || cols <= 0 || matrix == null || matrix.length == 0 ||
        str == null || str.length == 0 || index < 0) {
            return false;
        }
        if (!inOneDimensionRange(matrix, row, col, rows, cols)) {
            return false;
        }
        int indexMat = row * cols + col;
        // this bug is unexpected extremely stupid
        // int indexMat = row * cols + row;
        if (visitedFlag[indexMat]) {
            return false;
        }
        if (str[index] != matrix[indexMat]) {
            return false;
        }

        int[][] directs = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        if (index == str.length - 1) {
            return true;
        }

        visitedFlag[indexMat] = true;
        for (int i = 0; i < directs.length; i++) {
            int targetRow = directs[i][0] + row;
            int targetCol = directs[i][1] + col;
            if (existPath(matrix, targetRow, targetCol, rows, cols, str, index + 1)) {
                return true;
            }
        }
        visitedFlag[indexMat] = false;
        return false;
    }

    private static boolean inOneDimensionRange(char[] matrix, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            // not in the range
            return false;
        }
        return true;
    }

    private static void findPathInTwoDimension() {
        char[][] mat = new char[][]{
                {'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}
        };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        char[] targetString = new char[]{'a', 'c', 'j'};
        boolean exist = matExistPath(mat, targetString);
        System.out.println(exist);
    }

    private static boolean matExistPath(char[][] mat, char[] targetCharArr) {
        // back trace to find the path
        if (mat == null || mat.length <= 0 || mat[0].length <= 0) {
            return false;
        }
        int rows = mat.length;
        int cols = mat[0].length;
        visited = new boolean[rows][cols];
        boolean existFlag = false;
        // start position could be random within matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(mat, targetCharArr, i, j)) {
                    existFlag = true;
                }
            }
        }
        return existFlag;
    }

    private static boolean findPath(char[][] mat, char[] targetCharArr, int i, int j) {
        System.out.println(String.valueOf(targetCharArr));
        if (!inRange(mat, i, j)) {
            return false;
        }
        System.out.println("within range");
        if (visited[i][j]) {
            return false;
        }
        char current = mat[i][j];
        System.out.println("current:" + current);
        if (targetCharArr.length == 1 && targetCharArr[0] == current) {
            System.out.println("target char array is" + targetCharArr);
            return true;
        }
//        System.out.println("find a path");
//        System.out.println("target :" + String.valueOf(targetCharArr));

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        for(int d = 0; d < direction.length; d++) {
//            System.out.print(direction[d][0]);
//            System.out.print(" ");
//            System.out.print(direction[d][1]);
//            System.out.println();
//        }
        if (targetCharArr[0] == current) {
            visited[i][j] = true;
            // find its surrounding parts, up, down, left, right part
            for (int d = 0; d < direction.length; d++) {
                int row = direction[d][0] + i;
                int col = direction[d][1] + j;
                if (findPath(mat, String.valueOf(targetCharArr).substring(1,targetCharArr.length).toCharArray(), row, col)) {
                    return true;
                };
            }
            visited[i][j] = false;
        }
        return false;
    }

    private static boolean inRange(char[][] mat, int i, int j) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        return true;
    }
}
