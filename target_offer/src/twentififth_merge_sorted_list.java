public class twentififth_merge_sorted_list {
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
        ListNode list1 = new ListNode(10);
        ListNode list2 = new ListNode(15);
        ListNode current1 = list1;
        ListNode current2 = list2;
        for (int i = 16; i < 20; i++) {
            ListNode current = new ListNode(i);
            if (i % 2 == 0) {
                current1.next = current;
                current1 = current;
            } else {
                current2.next = current;
                current2 = current;
            }
        }
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        list1 = merge(list1, list2);
        System.out.println("list:" + list1);

    }

    public static ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null){
            return list1;
        }

        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode current = head;

        // easy to unlink the list
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                break;
            } else if (list2 == null) {
                current.next = list1;
                break;
            }

            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
        }
        return head;
    }


}
