import java.util.*;

public class Solution3Q2 {
    // use composition instead of inheritance
    private ArrayDeque<Integer> s1;
    private ArrayDeque<Integer> s2;

    public Solution3Q2() {
        s1 = new ArrayDeque<Integer>();
        s2 = new ArrayDeque<Integer>();
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
        if (s2.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return s2.peek();
        }
    }
}

