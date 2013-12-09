import java.util.*;
public class Solution3Q5 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());
        
        while (queue.size() != 0) {
            System.out.println(queue.dequeue());
        }
    }
}

class MyQueue<E> {
    ArrayDeque<E> inStack;
    ArrayDeque<E> outStack;
    
    public MyQueue() {
        inStack = new ArrayDeque<E>();
        outStack = new ArrayDeque<E>();
    }
    
    public void enqueue(E value) {
        inStack.push(value);
    }
    
    public E dequeue() {
        if (outStack.isEmpty()) {
            shiftStacks();
        }
        
        return outStack.pop();
    }
    
    public E peek() {
        if (outStack.isEmpty()) {
            shiftStacks();
        }
        
        return outStack.peek();
    }
    
    public int size() {
        return inStack.size() + outStack.size();
    }
    
    private void shiftStacks() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
