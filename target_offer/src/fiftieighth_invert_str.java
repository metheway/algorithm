public class fiftieighth_invert_str {
    public static void main(String[] args) {
        String str = "student. a am I";
//        System.out.println(reverseSentence(str));
//        System.out.println(reverseSentence(" "));
        //
        System.out.println(leftRotateString("abcdefg", 2));
    }
    static public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.replace(" ", "").length() == 0) {
            return str;
        }
        str = reverseSentence(str, 0, str.length() - 1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(reverseSentence(str, start, end));
                sb.append(" ");
                start = i + 1;
                end = i;
            } else {
                end++;
            }
        }
        sb.append(reverseSentence(str, start, end));
        return sb.toString();
    }

    private static String reverseSentence(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            sb.append(str.charAt(end));
            end--;
        }
        sb.append(str.charAt(start));
        return sb.toString();
    }
    public static String leftRotateString(String str,int n) {
        if (str == null || str.length() <= n || n <= 0) {
            return str;
        }
        int startFirst = 0;
        int startSec = n;
        int endFirst = n - 1;
        int endSec = str.length() - 1;
        String strFirst = reverseSentence(str, startFirst, endFirst);
        String strSec = reverseSentence(str, startSec, endSec);
        StringBuilder sb = new StringBuilder(strFirst);
        sb.append(strSec);
        return reverseSentence(sb.toString(), 0, str.length() - 1);
    }
}
