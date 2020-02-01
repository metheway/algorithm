import static java.lang.Integer.MIN_VALUE;

public class fortisec_maximum_seq {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, -2, 2, 2, 4};
        array = new int[]{1,-2,3,10,-4,7,2,-5};
        array = new int[]{-2,-8,-1,-5,-9};
        // 18
//        int res = findGreatestSumOfSubArray(array);
        int res = dp(array);
        System.out.println(res);
    }

    private static int dp(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    static int sum = 0;
    static public int findGreatestSumOfSubArray(int[] array) {
        int max = MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int current = recursive(array, i);
            if (max < current) {
                max = current;
            }
        }
        return max;
        // return sum end in index
    }

    private static int recursive(int[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return 0;
        }

        if (index == 0) {
            return array[index];
        }

        int before = recursive(array, index - 1);
        if (before < 0) {
            return array[index];
        } else {
            return array[index] + before;
        }
    }
}
