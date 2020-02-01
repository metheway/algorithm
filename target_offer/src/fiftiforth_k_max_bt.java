public class fiftiforth_k_max_bt {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static void main(String[] args) {

    }
    static int kth = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        kth = k;
        return kthNode(pRoot);
    }

    TreeNode kthNode(TreeNode pRoot) {
        // inorder to find kth node
        if (pRoot == null || kth <= 0) {
            return null;
        }

        // find kth node in left part
        TreeNode left = kthNode(pRoot.left);
        // if found, return left part
        if (left != null) {
            return left;
        } else {
            // if not found, minus the left part
            if (kth == 1) {
                return pRoot;
            }
            kth--;
        }

        // if not found in left part and root, search right part
        return kthNode(pRoot.right);
    }
}
