public class fiftififth_depth_of_bt {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public static void main(String[] args) {
        int[] a = new int[]{5};
        add(a);
        System.out.println(a[0]);
    }
    public static void add(int[] a) {
        a[0]++;
    }
    public int TreeDepth(TreeNode root) {
        // the longest path
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
    public boolean isBalanced_Solution(TreeNode root) {
        return isBalanced_Solution(root, new int[]{0});
    }

    private boolean isBalanced_Solution(TreeNode root, int[] depth) {
        if (root == null) {
            return true;
        }
        int[] leftDepth = {0};
        int[] rightDepth = {0};

        boolean left = isBalanced_Solution(root.left, leftDepth);
        boolean right = isBalanced_Solution(root.right, rightDepth);
        if (left && right) {
            if (Math.abs(leftDepth[0] - rightDepth[0]) <= 1) {
                // if the node is balanced, search continue, and depth should be added
//                depth++;
                // the bug is that depth could be accumulated
                depth[0] = leftDepth[0] > rightDepth[0] ? leftDepth[0] + 1 : rightDepth[0] + 1;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
