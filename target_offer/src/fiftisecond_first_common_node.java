public class fiftisecond_first_common_node {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int lFirst = 0;
        int lSec = 0;
        ListNode origHead1 = pHead1;
        ListNode origHead2 = pHead2;
        while (pHead1 != null) {
            lFirst++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            lSec++;
            pHead2 = pHead2.next;
        }
        pHead1 = origHead1;
        pHead2 = origHead2;

        if (lFirst > lSec) {
            while (lSec < lFirst) {
                pHead1 = pHead1.next;
                lSec++;
            }
        } else {
            while (lSec > lFirst) {
                pHead2 = pHead2.next;
                lSec--;
            }
        }

        while (pHead2 != null && pHead1 != null &&pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
