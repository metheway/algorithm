public class tentiforth_reverse_list {
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
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        System.out.println(head);
        head = reverseList(head);
        System.out.println(head);
    }
    public static ListNode reverseList(ListNode head) {
        if (head ==  null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode current = head.next;
        ListNode next = null;
        head.next = null;
        if (current != null) {
            next = current.next;
        } else {
            // current is null, and the only two node
            current.next = pre;
            pre.next = null;
            return current;
        }

        while (current.next != null) {
            current.next = pre;

            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }
}
