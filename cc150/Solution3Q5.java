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
    ArrayDeque<E> newStack;
    ArrayDeque<E> oldStack;
    
    public MyQueue() {
        newStack = new ArrayDeque<E>();
        oldStack = new ArrayDeque<E>();
    }
    
    public void enqueue(E value) {
        newStack.push(value);
    }
    
    public E dequeue() {
        if (oldStack.isEmpty()) {
            shiftStacks();
        }
        
        return oldStack.pop();
    }
    
    public E peek() {
        if (oldStack.isEmpty()) {
            shiftStacks();
        }
        
        return oldStack.peek();
    }
    
    public int size() {
        return newStack.size() + oldStack.size();
    }
    
    private void shiftStacks() {
        while (!newStack.isEmpty()) {
            oldStack.push(newStack.pop());
        }
    }
}
