public class thirtisixth_bidirect_bt {
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
    private static TreeNode preNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        preNode = null;
        // border test
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode lastNode = convert(pRootOfTree);

        while (lastNode.left != null) {
            lastNode = lastNode.left;
        }
        return lastNode;
    }


    private TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // get last node of root
        // inorder to traverse and get last node && convert
        convert(pRootOfTree.left);

        // do convert
        if (preNode == null) {
            preNode = pRootOfTree;
        } else {
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
            preNode = pRootOfTree;
        }

        convert(pRootOfTree.right);

        // maximum node in root
        return preNode;
    }

}
