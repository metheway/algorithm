import java.math.BigInteger;

public class seventeenth_print_n {
    public static void main(String[] args) {
        // print from 1 to n
        printToNum("100");
    }

    private static void printToNum(String num) {
        // the num could be pretty large
        BigInteger bigInteger = new BigInteger(num);
//        System.out.println(bigInteger.byteValue());
        BigInteger zero = new BigInteger("0");
        BigInteger incre = new BigInteger("1");
//        System.out.println(bigInteger.compareTo(zero));
//        System.out.println(zero.compareTo(bigInteger));
        while (zero.compareTo(bigInteger) <= 0) {
            System.out.println(zero.byteValue());
            zero = zero.add(incre);
        }
    }
}
