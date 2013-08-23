import java.util.*;
public class Solution3Q1 {
    private ArrayList<Stack> stacks = new ArrayList<Stack>();
    private final int capacity;
    
    public Solution3Q1(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if(stacks.size() == 0) {
            return null;
        }

        return stacks.get(stacks.size() - 1);
    }

    public void push(int v) {
        Stack last = getLastStack();

        if(last != null && !last.isFull()) { // add to last stack
            last.push(v);
        } else {// must create new stack
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        Stack last = getLastStack();
        int v = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return v;
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if (removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }

        return removedItem;
    }
}

class Stack {
    private final int capacity;
    private Node top, bottom;
    private int size = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(Node above, Node below) {
        if (below != null) {
            below.above = above;
        }

        if (above != null) {
            above.below = below;
        }
    }

    public boolean push(int v) {
        if (size >= capacity) {
            return false;
        }
        Node n = new Node(v);
        if (isEmpty()) bottom = n;
        join(n, top);
        top = n;
        size++;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int removeBottom() {
        assert(!isEmpty());
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) {
            bottom.below = null;
        }
        size--;
        return b.value;
    }

    private class Node {
        int value;
        Node above;
        Node below;

        public Node(int v) {
            this.value = v;
        }
    }
}
