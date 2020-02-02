public class eighth_next_node_inbt {
    // not solved
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeLinkNode{" +
                    "val=" + val ;
        }
    }
    public static void main(String[] args) {
        int[] inorder = new int[]{8,6,10,5,7,9,11};
        TreeLinkNode[] trees = new TreeLinkNode[inorder.length];
        for (int i = 0; i < inorder.length; i++) {
            trees[i] = new TreeLinkNode(inorder[i]);
        }
        // given a binary tree of inorder
        TreeLinkNode root = null;
        for (int i = inorder.length / 2; i >= 0; i--) {
            root = trees[i];
            int left = i * 2 + 1;
            int right = left + 1;
            if (left < inorder.length) {
                root.left = trees[left];
                trees[left].next = root;
            }
            if (right < inorder.length) {
                root.right = trees[right];
                trees[right].next = root;
            }
        }

        System.out.println(trees[3]);
        System.out.println(getNext(trees[3]));
        // inorder is l - n - r
    }
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return firstInorder(pNode.right);
        } else {
            // find parrent
            TreeLinkNode parrent = pNode.next;
            while (parrent != null && parrent.left != pNode) {
                pNode = parrent;
                parrent = pNode.next;
            }
            if (parrent != null) {
                return parrent;
            }
        }
        return null;
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // if current node has a right branch, next node would be the first node in right branch
        if (pNode.right != null) {
            return firstInorder(pNode.right);
        // if current node does not own a right branch
        } else {
            // if current node is the left node of its father node
            if (pNode.next != null && pNode == pNode.next.left) {
                // the next node would be the father node
                return pNode.next;
            } else if (pNode.next != null) {
                // if current node is the right node of its father
                // seek up along its father until find a ancestor node who is the left node of another node
                boolean findNode = false;
                while (pNode.next != null) {
                    if (pNode.next.left == pNode) {
                        findNode = true;
                        break;
                    }
                    pNode = pNode.next;
                }
                if (findNode) {
                    return pNode;
                } else {
                    // if not found node whose parent is...
                    return null;
                }
            } else {
                // if else, namely maybe the parent node not exist
                return null;
            }
        }
    }

    private static TreeLinkNode firstInorder(TreeLinkNode right) {
        if (right.left != null) {
            return firstInorder(right.left);
        } else {
            return right;
        }
    }
}
