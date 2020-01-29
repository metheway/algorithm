import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class level_create {
    public static class TreeNode {
        int val;
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
        TreeNode head = new TreeNode(0);
        // build tree by level
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(head);

        for (int i = 1; i < 10; i++) {
            TreeNode current = new TreeNode(i);
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

        System.out.println(head);
//        System.out.println(list.get(1));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
    }
}
