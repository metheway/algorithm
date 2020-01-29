public class thirtithird_post_of_bst {
    public static void main(String[] args) {
        int[] seq = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] seqSec = new int[]{4,8,6,12,16,14,10};
        int[] seqThird = new int[]{7,4,6,5};
        // false
        System.out.println(VerifySquenceOfBST(seq));
        System.out.println(VerifySquenceOfBST(seqSec));
        System.out.println(VerifySquenceOfBST(seqThird));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        return verifySeqOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySeqOfBST(int[] sequence, int start, int end) {
        if (end == start) {
            return true;
        } else if (end < start) {
            return false;
        }

        int root = sequence[end];
        int rightEnd;
        int rightStart;

        // search left to find border of left
        for (rightStart = start; rightStart < end; rightStart++) {
            if (sequence[rightStart] < root) {
                continue;
            } else {
                break;
            }
        }

        // search to left find the first one larger than root
        for (rightEnd = rightStart; rightEnd < end; rightEnd++) {
            if (sequence[rightEnd] < root) {
                return false;
            }
        }
        boolean leftSeqOfBST = rightStart > start ? verifySeqOfBST(sequence, start, rightStart - 1) : true;
        boolean rightSeqOfBST = rightEnd > rightStart ? verifySeqOfBST(sequence, rightStart + 1, rightEnd) : true;

        return leftSeqOfBST && rightSeqOfBST;
    }
}
