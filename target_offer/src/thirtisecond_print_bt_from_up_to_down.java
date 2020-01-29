import java.util.ArrayList;
import java.util.Stack;

public class thirtisecond_print_bt_from_up_to_down {

     public static class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
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

//        for(int i = 0; i < 10; i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(head);
        System.out.println(printFromTopToBottom(head));
//        System.out.println(printLevel(head));
        System.out.println(printDiverse(head));
    }

    public static ArrayList<ArrayList<Integer> > printDiverse(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        // two stack
        Stack<TreeNode> stackFirst = new Stack();
        Stack<TreeNode> stackSec = new Stack();
        stackFirst.add(pRoot);

        // two var
        int toBePrint = 1;
        int nextLevel = 0;
        boolean oddLevel = true;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> currentLevel = new ArrayList<>();
        while (!stackFirst.isEmpty() || !stackSec.isEmpty()) {
            TreeNode current = null;
            if (oddLevel) {
                current = stackFirst.pop();
                if (current.left != null) {
                    stackSec.add(current.left);
                    nextLevel++;
                }
                if (current.right != null) {
                    stackSec.add(current.right);
                    nextLevel++;
                }
            } else {
                current = stackSec.pop();
                if (current.right != null) {
                    stackFirst.add(current.right);
                    nextLevel++;
                }
                if (current.left != null) {
                    stackFirst.add(current.left);
                    nextLevel++;
                }
            }
            if (current == null) {
                break;
            }
            currentLevel.add(current.val);
            toBePrint--;
            if (toBePrint == 0) {
                oddLevel = oddLevel ? false : true;
                list.add(currentLevel);
                currentLevel = new ArrayList<>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
        return list;
    }

    static ArrayList<TreeNode> queue = new ArrayList<>();
    public static ArrayList<ArrayList<Integer> > printLevel(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        // two var should be set: nodes of next level && nodes to be print
        int toBePrint = 1;
        int nextLevel = 0;
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> currentLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove(0);
            if (current.left != null) {
                queue.add(current.left);
                nextLevel++;
            }
            if (current.right != null) {
                queue.add(current.right);
                nextLevel++;
            }
            currentLevel.add(current.val);
            toBePrint--;
            if (toBePrint == 0) {
                // it is the last node of this level
                list.add(currentLevel);
                currentLevel = new ArrayList<>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
        return list;
    }
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);

        while (queue.size() != 0) {
            TreeNode current = queue.remove(0);
            list.add(current.val);

            // i made a mistake for taking root as current
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return list;
    }

}
