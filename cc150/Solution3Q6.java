import java.util.*;
public class Solution3Q6 {
    public static void sortStack(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> auxStack = new ArrayDeque<Integer>(); 
        
        while (!stack.isEmpty()) {// insert each into aux(sorted)
            int top = stack.pop();
            while (!auxStack.isEmpty() && top > auxStack.peek()) {
                stack.push(auxStack.pop());
            }
            auxStack.push(top);
        }
        
        // push back to original stack
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }
    
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(6);
        stack.push(8);
        stack.push(1);
        stack.push(3);
        sortStack(stack);
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
