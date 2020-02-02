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
                    ", next=" + next +
                    ", random=" + random + "}";
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,3,5,-1,2,-1};
        RandomListNode head = new RandomListNode(arr[0]);
        RandomListNode current = head;

        for (int i = 1; i < 10; i++) {
            RandomListNode node = new RandomListNode(arr[i]);
            current.next = node;
            current = node;
        }


        RandomListNode cpHead = myClone(head);
//        RandomListNode cpHead = Clone(head);
        System.out.println(head.toString());
        System.out.println(cpHead);
    }

    private static RandomListNode myClone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = pHead;
        RandomListNode origHead = head;
        RandomListNode randomListNode = new RandomListNode(head.label);
        RandomListNode cpHead = randomListNode;
        head = head.next;
        // copy node
        while (head != null) {
            RandomListNode current = new RandomListNode(head.label);
            randomListNode.next = current;
            randomListNode = current;
            head = head.next;
        }

        // System.out.println(cpHead);
        // link
        head = origHead;
        randomListNode = cpHead;
        while (head != null) {
            RandomListNode origNext = head.next;
            RandomListNode cpNext = randomListNode.next;
            head.next = randomListNode;
            randomListNode.next = origNext;

            head = origNext;
            randomListNode = cpNext;
        }
//        System.out.println(origHead);

        // copy random
        head = origHead;
        randomListNode = cpHead;
        while (head != null) {
            if (head.random != null) {
                randomListNode.random = head.random.next;
            }
            if (head.next.next != null) {
                head = head.next.next;
            } else {
                break;
            }
        }

        // unlink
        head = origHead;
        randomListNode = cpHead;
        while (randomListNode != null && head != null) {
            RandomListNode origNext = randomListNode.next;
            RandomListNode cpNext = null;
            if (origNext != null) {
                cpNext = origNext.next;
            }

            head.next = origNext;
            randomListNode.next = cpNext;

            head = origNext;
            randomListNode = cpNext;
        }
        return cpHead;
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

    public RandomListNode CloneAns(RandomListNode pHead){

        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}
