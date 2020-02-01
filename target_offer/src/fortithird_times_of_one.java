public class fortithird_times_of_one {
    public static void main(String[] args) {
//        int times = numberOf1Between1AndN_Solution(12);
//         16
//        int times = numberOf1Between1AndN_Solution(55);
        int times = numberOf1Between1AndN_Solution(21345);
        // 18821
        System.out.println(times);
    }
    static public int numberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // from top digit to lower, 0~9, 10~19, ..., 100~199
        int digits = getDigits(n);
        int highDigit = getHighNum(n);

        int oneHighcount = 0;
        // 1 is 10^0, 2digits is 10^1
        if (highDigit == 1) {
//            System.out.println(n);
//            oneHighcount = n - highDigit * (int)Math.pow(10, digits - 1);
//            if (n == Math.pow(10, digits - 1)) {
//                oneHighcount++;
//            }
            oneHighcount = n - highDigit * (int)Math.pow(10, digits - 1) + 1;
//            System.out.println(digits);
        } else {
            oneHighcount = (int) Math.pow(10, digits - 1);;
        }
//        System.out.println("n:" + n);
//        System.out.println(oneHighcount);
        int part1 = oneHighcount;
        int part2 = numberOf1Between1AndN_Solution(n - highDigit * (int)Math.pow(10, digits - 1));
        int part3 = (highDigit )* numberOf1Between1AndN_Solution((int) Math.pow(10, digits - 1) - 1);
        System.out.println("part1:" + part1);
        System.out.println("part2:" + part2);
        System.out.println("part3:" + part3);
        return part1 + part2 + part3;
    }

    private static int getHighNum(int n) {
        int high = n;
        while (n > 0) {
            high = n;
            n /= 10;
        }
        return high;
    }

    private static int getDigits(int n) {
        int digits = 0;
        while (n > 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }
}
