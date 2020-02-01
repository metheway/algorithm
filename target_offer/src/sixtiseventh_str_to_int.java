import java.math.BigInteger;

public class sixtiseventh_str_to_int {
    public static void main(String[] args) {
        System.out.println(strToInt("12515"));
        System.out.println(strToInt("0"));
        System.out.println(strToInt(""));
    }
    public static int strToInt(String str) {
        if (str == null || str.length() == 0 || str.equals("0")) {
            return 0;
        }
        BigInteger num = new BigInteger("0");
        int i = 0;
        int multiNeg = 1;
        if (str.charAt(0) == '-') {
            i++;
            multiNeg = -1;
        } else if (str.charAt(0) == '+') {
            multiNeg = 1;
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num.add(new BigInteger(String.valueOf(c)));
                if (i == str.length() - 1) {
                    break;
                } else {
                    num = num.multiply(new BigInteger("10"));
//                    num *= 10;
                }
            } else {
                return 0;
            }
        }

        // judge logic
        num = num.multiply(new BigInteger(String.valueOf(multiNeg)));
        if (num.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
            return 0;
        }
        if (num.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
            return 0;
        }
        return num.intValue();
    }
}
