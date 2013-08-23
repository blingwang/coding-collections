import java.util.*;

public class Solution3Q2 {
    // use composition instead of inheritance
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public Solution3Q2() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        s1.push(value);
        
        if (s2.isEmpty() || value <= min()) {
            s2.push(value);
        }
    }

    public int pop() {
        int value = s1.pop();
        
        if (value == min()) {
            s2.pop();
        }
        
        return value;
    }

    public int min() {
        if (s2.isEmpty()) { // or use EmptyStackException?
            throw new EmptyStackException("Stack is empty"); 
        } else {
            return s2.peek();
        }
    }
}

