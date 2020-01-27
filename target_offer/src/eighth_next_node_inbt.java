public class eighth_next_node_inbt {
    // not solved
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        // given a binary tree of inorder
        // inorder is l - n - r
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

    private TreeLinkNode firstInorder(TreeLinkNode right) {
        if (right.left != null) {
            return firstInorder(right.left);
        } else {
            return right;
        }
    }
}
