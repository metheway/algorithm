import java.util.List;

public class twentithird_entry_in_loop {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        ListNode entryNode = null;
        for (int i = 2; i < 10; i++) {
            ListNode node = new ListNode(i);
            if (i == 5) {
                entryNode = node;
            }
            current.next = node;
            current = node;
        }
        entryNode = head;
        System.out.println("entry:" + entryNode);
        current.next = entryNode;
        System.out.println(entryNodeOfLoop(head));
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val;
        }
    }
    public static ListNode entryNodeOfLoop(ListNode pHead)
    {
        // if no entry in the loop?

        int loopNum = 0;
        if (pHead == null) {
            return null;
        }
        if (pHead.next == pHead) {
            return pHead;
        }
        ListNode quick = pHead;
        ListNode slow = pHead;
        if (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        // find loop
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                if (quick == pHead) {
                    return pHead;
                }
                // exist loop
                // find loop num
                slow = slow.next;
                loopNum++;
                while (slow != quick) {
                    slow = slow.next;
                    loopNum++;
                }
                break;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        loopNum++;
        // then start from start
        quick = pHead;
        slow = pHead;
        if (loopNum > 1) {
            for (int i = 0; i < loopNum; i++) {
                quick = quick.next;
            }
            while (quick != slow) {
                quick = quick.next.next;
                slow = slow.next;
            }
        } else {
            return null;
        }
        return slow;
    }
}
