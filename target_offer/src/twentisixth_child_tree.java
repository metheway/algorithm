public class twentisixth_child_tree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // {8,8,7,9,3,#,#,#,#,4,7},{8,9,2}
        // create tree by layer  nodes = pow(2, level - 1) level starts from 1
        String treeString1 = new String("8,8,7,9,3,#,#,#,#,4,7");
        String treeString2 = new String("8,9,2");
        char[] treeChar1 = treeString1.replace(",", "").toCharArray();
        char[] treeChar2 = treeString2.replace(",", "").toCharArray();
        // total nodes should be pow(2, level) - 1
        int levelFirst = getLevel(treeChar1.length);
        int levelSec = getLevel(treeChar2.length);

        TreeNode root1 = new TreeNode(treeChar1[0]);
        TreeNode root2 = new TreeNode(treeChar2[0]);

        int index1 = 0;
        int index2 = 0;
        while (index1 < treeChar1.length) {
            TreeNode node = buildTree(treeChar1, index1);
            root1.left = node;

            root1.right = node;
        }
    }

    private static TreeNode buildTree(char[] treeChar, int index) {
        // create tree
        if (treeChar[index] != '#') {
            TreeNode treeNode = new TreeNode(treeChar[index]);
        }
        return null;
    }

    private static int getLevel(int length) {
        int level = 0;
        while (length > 0) {
            level++;
            length /= 2;
        }
        return level;
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = containTree(root1, root2);
            }
            {
                if (result == false) {
                    result = HasSubtree(root1.left, root2);
                }
                if (result == false) {
                    result = HasSubtree(root1.right, root2);
                }
            }
        }
        return result;
    }

    private static boolean containTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return true;
        }

        if (root1.val != root2.val) {
            return false;
        }
        // if root1 is the same structure as root2
        return containTree(root1.left, root2.left) && containTree(root1.right, root2.right);
    }
}
