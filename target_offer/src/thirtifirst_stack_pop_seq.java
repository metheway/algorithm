import java.util.Stack;

public class thirtifirst_stack_pop_seq {
    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push, pop));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }

        // pushA push to stack and compare to popA
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int stackIndex = 0;
        while (index < pushA.length) {
            if (pushA[index] == popA[stackIndex]) {
                index++;
                stackIndex++;
            } else {
                // if the node is not adapt
                if (stack.isEmpty() || stack.peek() != popA[stackIndex]) {
                    stack.push(pushA[index]);
                    index++;
                } else if (stack.peek() == popA[stackIndex]){
                    stack.pop();
                    stackIndex++;
                } else {
                    stack.push(pushA[index]);
                    index++;
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == popA[stackIndex]) {
                stackIndex++;
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
