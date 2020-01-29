import java.util.ArrayList;

public class thirtiforth_path_of_spec_sum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }


    public static ArrayList<TreeNode> createFromLevel(int[] arr){
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(arr[0]);
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(head);

        for (int i = 1; i < arr.length; i++) {
            TreeNode current = new TreeNode(arr[i]);
            list.add(current);
        }

        for (int i = list.size() / 2; i >= 0; i--) {
            TreeNode current = list.get(i);
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < list.size()) {
                current.left = list.get(left);
            }
            if (right < list.size()) {
                current.right = list.get(right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // 10,5,12,4,7},22
        int[] tree = new int[]{10, 5, 12, 4, 7};
        tree = new int[]{10, 5, 12, 4, 7};
        // 10,5,12,4,7},15
        ArrayList<TreeNode> treePath = createFromLevel(tree);
        FindPath(treePath.get(0), 15);
        System.out.println(list);
    }

    static ArrayList<ArrayList<Integer>> list;
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        list = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        // the target could be negative
        ArrayList<Integer> nextPath = new ArrayList<>();
        traverseToLeaf(nextPath, root, target);
        return list;
    }

    private static void traverseToLeaf(ArrayList<Integer> nextPath, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        nextPath.add(root.val);
        if (isLeaf(root)) {
            if (target == root.val) {
                list.add(new ArrayList<>(nextPath));
            }// else {
            //    return;
            //}
        } // else {
        traverseToLeaf(nextPath, root.left, target - root.val);
        traverseToLeaf(nextPath, root.right, target - root.val);
        nextPath.remove(nextPath.size() - 1);
        // }

        // this is a bug, if else and return, then nextPath would not remove the last node
    }

    private static boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

}
