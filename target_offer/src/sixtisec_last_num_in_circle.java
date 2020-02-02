public class sixtisec_last_num_in_circle {
    public static void main(String[] args) {

    }
    public int LastRemaining_Solution(int n, int m) {
        // list is a method
        // f(n, m) = (f(n - 1, m) + k + 1) % n, k = (0 + m - 1) % n
        // f(n, m) = (f(n - 1, m) + m) %n
        if (n <= 0 || m <= 0) {
            return -1;
        } else if (m == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}















// sec, f(n, m) represents start %m with circle counts is n
// f(n, m) = 0 ~ n - 1 choose k = (m - 1) % n, so lasts 0, 1, 2, ..., k - 1, k + 1, n - 1 starts from k - 1
// f(n - 1, m) + k + 1 % n


