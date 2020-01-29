import java.util.Arrays;

public class twentieighth_asynmetric_bt {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        // n - l - r, n - r - l are the same, including null
    }

    private static boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }

    private static boolean isSymmetrical(TreeNode pRootFirst, TreeNode pRootSec) {
        if (pRootFirst == null && pRootSec == null) {
            return true;
        }
        if (pRootFirst == null || pRootSec == null) {
            return false;
        }
        if (pRootFirst.val != pRootSec.val) {
            return false;
        }
        return isSymmetrical(pRootFirst.left, pRootSec.right) &&
                isSymmetrical(pRootFirst.right, pRootSec.left);
    }
}
