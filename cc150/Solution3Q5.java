import java.util.*;

class Solution3Q5 {}
class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public T peek() {
        shiftStacks(); // ensure stackOldest has the current elements
        return stackOldest.peek(); // retrieve the oldest item
    }

    public T remove() {
        shiftStacks(); // ensure stackOldest has the current elements
        return stackOldest.pop(); // pop the oldest item
    }

    /*
     * Move elements from stackNewest into stackOldest. This is 
     * usually done so that we can do operations on stackOldest.
     */
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
