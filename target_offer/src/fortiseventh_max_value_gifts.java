public class fortiseventh_max_value_gifts {
    static int maxValue = 0;
    public static void main(String[] args) {
        int[][] chesses = new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6},
                {5, 7, 4, 11}, {3, 7, 16, 5}};
        // backTracing
        startFrom(chesses, 0, 0, 0);
        System.out.println("max:" + maxValue);

        // recursive
        maxValue = startFromRec(chesses, 0, 0);
        System.out.println(maxValue);

        // dynamic programming
        int[][] dp = new int[chesses.length][chesses[0].length];
        dp[0][0] = chesses[0][0];

        for (int i = 1; i < chesses.length; i++) {
            dp[0][i] = chesses[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < chesses[0].length; i++) {
            dp[i][0] = chesses[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < chesses.length; i++) {
            for (int j = 1; j < chesses[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + chesses[i][j];
            }
        }
        System.out.println(dp[chesses.length - 1][chesses[0].length - 1]);
    }


    private static int startFromRec(int[][] chesses, int row, int col) {
        if (chesses == null || row >= chesses.length || col >= chesses.length
        || row < 0 || col < 0) {
            return 0;
        }

        // start from row and col
        return chesses[row][col] + Math.max(
                startFromRec(chesses, row + 1, col),
                startFromRec(chesses, row, col + 1)
        );
    }

    private static void startFrom(int[][] chesses, int row, int col, int count) {
        int rows = chesses.length;
        int cols = chesses[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        count += chesses[row][col];
        if (row == rows - 1 && col == cols - 1) {
            if (maxValue < count) {
                maxValue = count;
            }
            return;
        }
        startFrom(chesses,row + 1, col, count);
        startFrom(chesses, row,col + 1, count);
//        value -= chesses[row][col];
    }
}
