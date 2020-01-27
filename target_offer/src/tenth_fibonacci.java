public class tenth_fibonacci {
    public static void main(String[] args) {
        getFibonacciIndex(0);
        waysOfJumpFrog(0);
    }

    private static int waysOfJumpFrog(int index) {
        // a frog could jump up 1 floor or 2
        int[] f = new int[100];
        // f[n] = f[n - 1] + f[n - 2]
        f[1] = 1;
        f[2] = 1;
        f[3] = 2;
        for(int i = 3; i < 100; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[index];
    }

    private static int getFibonacciIndex(int index) {
        int[] f = new int[100];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < 100; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[index];
    }
}
