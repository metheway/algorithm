public class eighteenth_delete_node {
    // my solution is a bit complex, it could be abbreviated
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
        ListNode list = new ListNode(1);
        ListNode secNode = new ListNode(1);
        ListNode thirdNode = new ListNode(1);
        list.next = secNode;
        secNode.next = thirdNode;

//        list = deleteNode(list, secNode);
//        System.out.println(list);
        System.out.println(list);

        list = deleteDuplication(list);
        System.out.println(list);
    }

    public static ListNode deleteNode(ListNode pHead, ListNode pDeleted) {
        // 3 case, 1 node/ last node/ normal
        // safety test
        if (pHead == null || pDeleted == null) {
            return null;
        }
        if (pHead == pDeleted && pDeleted.next == null) {
            return null;
        } else if (pDeleted.next == null) {
            // the last node is the node to be deleted
            // we should search for the previous node of pDeleted
            ListNode tmpNode = pHead;
            while (tmpNode.next != pDeleted) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = null;
        } else {
            pDeleted.val = pDeleted.next.val;
            pDeleted.next = pDeleted.next.next;
        }
        return pHead;
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        // wrong or border input test
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        while (pHead.next != null && isDuplicated(pHead)){
            // if head node is duplicated
            int value = pHead.val;
            if (isDuplicated(pHead)) {
                while (pHead != null && value == pHead.val) {
                    pHead = pHead.next;
                }
            }
            if (pHead == null) {
                return null;
            }
        }


        ListNode preNode = pHead;
        ListNode current = pHead.next;
        while (current != null) {
//            int value = current.val;
            while (isDuplicated(current)) {
                int value = current.val;
                // duplicated one
                while (current != null && value == current.val) {
                    current = current.next;
                }
            }
            // connect
            preNode.next = current;
            preNode = current;
            if (current != null) {
                current = current.next;
            }
        }
        return pHead;
    }

    private static boolean isDuplicated(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return false;
        }
        if (pHead.next.val == pHead.val) {
            return true;
        }
        return false;
    }
}
