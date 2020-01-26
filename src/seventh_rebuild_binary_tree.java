public class seventh_rebuild_binary_tree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        return constructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode constructCore(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        // find left part in pre array and in array
        // first find division positon in in array
        int division = inStart;
        for(int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                division = i;
            }
        }

        // length of left part is (division - inStart)
        // length of right part is (inEnd - division)
        int leftPreStart = preStart + 1;
        int leftPreEnd = preStart + 1 + (division - inStart) - 1;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;

        int leftInStart = inStart;
        int leftInEnd = inStart + (division - inStart) - 1;
        int rightInStart = division + 1;
        int rightInEnd = inEnd;

        root.left = constructCore(pre, leftPreStart, leftPreEnd, in, leftInStart, leftInEnd);
        root.right = constructCore(pre, rightPreStart, rightPreEnd, in, rightInStart, rightInEnd);
        return root;
    }
}
