import java.util.*;
public class Solution3Q6 {
    public static void sortStack(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> aux = new ArrayDeque<Integer>();
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!aux.isEmpty() && top > aux.peek()) {
                stack.push(aux.pop());
            }
            aux.push(top);
        }
        
        // push back to original stack
        while (!aux.isEmpty()) {
            stack.push(aux.pop());
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
