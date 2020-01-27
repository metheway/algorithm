import java.util.List;

public class twentisecond_last_kth_node {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        System.out.println(findKthToTail(head, 1));
    }

    private static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode first = head;
        ListNode sec = head;
        int index = 0;
        while (sec != null) {
            if (index < k) {
                sec = sec.next;
                index++;
            } else {
                first = first.next;
                sec = sec.next;
                index++;
            }
        }
        if (index <= k) {
            return first;
        } else {
            return null;
        }
    }

    public static ListNode myFindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode sec = head;
        int index = 0;
        while (sec.next != null) {
            if (index < k) {
                sec = sec.next;
                index++;
            } else {
                first = first.next;
                sec = sec.next;
                index++;
            }
        }
        if (index >= k) {
            return first;
        } else {
            return null;
        }
    }
}
