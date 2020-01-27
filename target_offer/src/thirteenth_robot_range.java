public class thirteenth_robot_range {
    // this algorithm is time consumable to me
    // debug is painful
    private static int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    private static boolean[][] visited;
    public static boolean DEBUG = true;
    private static int result = 0;

    public static void main(String[] args) {
        int count = movingCount(5, 10, 10);
        if (DEBUG) {
            // the result should be 21
            System.out.println("Result is 21:" + count);
//            System.out.println(result);
        }
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold <= 0) {
            return -1;
        }
        visited = new boolean[rows][cols];
        RangeUtil.init(rows, cols);
        // start from (0, 0)
        return startMovingFrom(threshold, 0, 0);
    }

    private static int startMovingFrom(int threshold, int row, int col) {
        // if not in range or not within threshold, return 0
        if (!RangeUtil.withinRange(row, col) || !RangeUtil.withinThreshold(threshold, row, col)) {
            return 0;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;

        int targetRow;
        int targetCol;
        // int maxMovingRange = 0;
        // result ++;
//        int movingRange = 0;
        int tmpMoving = 0;
        for (int i = 0; i < directions.length; i++) {
        // movingRange = 0;
            targetRow = directions[i][0] + row;
            targetCol = directions[i][1] + col;
            // if the target is not in the threshold or legal range, just skip
            if (DEBUG) {
                //print once is enough
                // it should be false
                System.out.println("within threshold:" + RangeUtil.withinThreshold(6,33,1));
                // it should be true
                System.out.println("within range:" + RangeUtil.withinRange(5, 5));
                // test show bug here
            }
            if (!RangeUtil.withinRange(targetRow, targetCol) || !RangeUtil.withinThreshold(threshold, targetRow, targetCol)) {
                continue;
            }
            // return 4 directions moving plus 1
            tmpMoving += startMovingFrom(threshold, targetRow, targetCol);
//            result += startMovingFrom(threshold, targetRow, targetCol);
//            movingRange += 1 + startMovingFrom(threshold, targetRow, targetCol);
//            if (maxMovingRange < movingRange) {
//                maxMovingRange = movingRange;
//            }
        }
        return tmpMoving + 1;
//        return maxMovingRange;
//        return movingRange;
//        return result;
    }

    private static int getDigits(int num) {
        int count = 0;
        while (num > 0) {
//            count ++ is wrong
            count += num % 10;
            num /= 10;
//            count ++;
        }
        return count;
    }

    private static class RangeUtil {
        public static int rows, cols;

        private static boolean withinThreshold(int threshold, int targetRow, int targetCol) {
            if (DEBUG) {
                System.out.println("row is:" + targetRow +
                        " digits of row:" + getDigits(targetRow));
                System.out.println("col:" + targetCol + " digits of col:" +
                        getDigits(targetCol));
            }
            return threshold >= (getDigits(targetRow) + getDigits(targetCol)) ? true : false;
        }

        public static boolean withinRange(int row, int col) {
            if (DEBUG) {
                System.out.println("range judge rows:" + rows);
                System.out.println("range judge cols:" + cols);
                // bug shows that the value has not been passed to rows and cols
            }
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return false;
            }
            return true;
        }

        public static void init(int rowsNum, int colsNum) {
            rows = rowsNum;
            cols = colsNum;
            if (DEBUG) {
                System.out.println("rows:" + rows);
                System.out.println("cols:" + cols);
            }
        }
    }
}
