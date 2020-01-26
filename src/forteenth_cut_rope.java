public class forteenth_cut_rope {
    public static void main(String[] args) {
        System.out.println(cutRopeRecursive(10));
        System.out.println(curRopeDp(10));
        System.out.println(curRopeGreedy(10));
    }

    private static int curRopeGreedy(int target) {
        // cut 3 as much as possible
        // 3 * (n - 3) > 2 * (n - 2) and 4 * (n - 4) == 2 * 2 * (n - 4) < 2 * 3 * (n - 5)
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }

        if (target % 3 == 0) {
            return (int) Math.pow(3, target / 3);
        } else {
            // if the length remain is more than 2
            if (target % 3 == 1) {
                return (int) (4 * Math.pow(3, target / 3 - 1));
            } else {
                return (int) (Math.pow(3, target / 3) * 2);
            }
        }
    }

    private static int curRopeDp(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        } else if(target == 3) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[target];
    }

    private static int cutRopeRecursive(int target) {
        // f(n) = max(f(n - 3) * 3, f(n - 2) * 2)
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        } else if (target == 4) {
            return 4;
        } else if (target == 5) {
            return 6;
        }
        return Math.max(cutRopeRecursive(target - 2) * 2,
                cutRopeRecursive(target - 3) * 3);
    }
}
