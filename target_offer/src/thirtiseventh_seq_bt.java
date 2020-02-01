public class thirtiseventh_seq_bt {
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
    static int index = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode current = treeNode;
        for (int i = 1; i < 10; i++) {
            TreeNode node = new TreeNode(i);
            if (i % 2 == 0) {
                current.left = node;
            } else {
                current.right = node;
            }
            current = node;
        }
//        String str = Serialize(treeNode);
//        System.out.println(str);
//        System.out.println(Deserialize(str));
//        System.out.println();
        System.out.println(Deserialize(new String("5,4,#,3,#,2")));
    }
    static String Serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }

        // store in pre seq
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left != null) {
            sb.append(",");
            preorder(root.left, sb);
        } else {
            sb.append(",");
            sb.append("#");
        }

        if (root.right != null) {
            sb.append(",");
            preorder(root.right, sb);
        } else {
            sb.append(",");
            sb.append("#");
        }
    }


    static TreeNode Deserialize(String str) {
        String[] chars = str.split(",");
        return preBuildTree(chars);
    }

    private static TreeNode preBuildTree(String[] str) {
        if (index >= str.length) {
            return null;
        }

        TreeNode treeNode = null;
        if (!str[index].equals("#")) {
            // 一个java内存的陷阱，都最终指向常量池。但当前str[index]是指向常量池的地址，而"#"是常量，直接判断==必然不相等
            // equals通过先判断hashcode在toString()的方式，保证了只要指向常量的引用都相等
//            System.out.println((str[index].equals("$")));
//            System.out.println(str[index]);
            treeNode = new TreeNode(Integer.parseInt(str[index]));
            index++;
            treeNode.left = preBuildTree(str);
            treeNode.right = preBuildTree(str);
        } else {
            // this bug: remember to track the index
            index++;
        }
        return treeNode;
    }

}
