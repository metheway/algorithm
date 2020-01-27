public class fifth_replace_space {
    public static void main(String[] args) {
        String originalStr = "We Are Happy";
        System.out.println("before replace:" + originalStr);
        originalStr = replaceSpace(new StringBuffer(originalStr));
        System.out.println("after replace:" + originalStr);
    }

    public static String replaceSpace(StringBuffer str) {
        //return new String(str).replace(" ","%20");
        int pRaw = str.length() - 1;
        int spaceCount = 0;
        int pTarget = 0;
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                spaceCount++;
            }
        }
        pTarget = spaceCount * 2 + str.length();
        str.setLength(pTarget);
        pTarget--;
        while (pRaw < pTarget) {
            if (pRaw < 0 || pTarget < 0) {
                return str.toString();
            }
            Character c = str.charAt(pRaw);
            if (c == ' ') {
                str.setCharAt(pTarget--, '0');
                str.setCharAt(pTarget--, '2');
                str.setCharAt(pTarget--, '%');
            } else {
                str.setCharAt(pTarget, c);
                pTarget--;
            }
            pRaw--;
        }
        return str.toString();
    }
}
