public class sixtisixth_multi_arr {
    public static void main(String[] args) {
        // b[i] = a[0] * a[1] * ... * a[i - 1] * (a[i + 1] * a[i + 2] * .. * a[n - 1])
        // b[i] = c[i] * d[i]
    }
    static public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] c = new int[A.length];
        int[] d = new int[A.length];
        int[] b = new int[A.length];
        c[0] = 1;
        for (int i = 1; i < A.length; i++) {
            c[i] = c[i - 1] * A[i - 1];
        }

        d[A.length - 1] = 1;
        for (int i = A.length - 1 - 1; i >= 0; i--) {
            d[i] = d[i + 1] * A[i + 1];
        }

        for (int i = 0; i < A.length; i++) {
            b[i] = c[i] * d[i];
        }
        return b;
    }
}
