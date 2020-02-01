public class thirtififth_cp_com_list {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "label=" + label +
                    ", next=" + next;
        }
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode current = head;

        for (int i = 1; i < 10; i++) {
            RandomListNode node = new RandomListNode(i);
            current.next = node;
            current = node;
        }
        RandomListNode cpHead = Clone(head);
        System.out.println(head.toString());
        System.out.println(cpHead);
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cpHead = new RandomListNode(pHead.label);
        RandomListNode current = cpHead;
        RandomListNode headList = pHead.next;

        // copy a list
        while (headList != null) {
            RandomListNode node = new RandomListNode(headList.label);
            current.next = node;
            current = node;
            headList = headList.next;
        }

        headList = pHead;
        current = cpHead;

        // link the cp node after pHead
        while (headList != null) {
            RandomListNode origNext = headList.next;
            RandomListNode cpNext = current.next;

            headList.next = current;
            current.next = origNext;

            headList = origNext;
            current = cpNext;
        }

        headList = pHead;

        // start do cp random part
        while (headList != null) {
            current = headList.next;

            if (headList.random != null) {
                current.random = headList.random.next;
            }

            if (headList.next != null) {
                headList.next = headList.next.next;
                headList = headList.next;
            } else {
                // the last node
                headList.next = null;
            }
            // reconnect
        }
        System.out.println(pHead);
        System.out.println(cpHead);
        return cpHead;
    }

}
