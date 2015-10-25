class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;
    
    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    public void push(int x) {
        stack.push(x);
        
        int min = x;
        if (!minStack.isEmpty() && x > getMin()) {
            min = getMin();
        }
        
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();    
    }

    public int getMin() {
        return minStack.peek();    
    }
}
