public class fiftith_first_once_char {
    public static void main(String[] args) {

    }
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] chars = new int[99];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i) - 'A'] == 1) {
                return i;
            }
        }
        return 0;
    }
}
