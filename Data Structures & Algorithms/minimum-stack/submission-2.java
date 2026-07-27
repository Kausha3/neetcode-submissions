class MinStack {
    Stack<Long> stack;
    long min = Long.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {

        if (stack.isEmpty()) {
            min = (long) val;
            stack.push((long) val);
        }
        else if (val < min) {
            long newValue = 2 * (long) val -  min;
            stack.push(newValue);
            min = (long) val;
        }
        else {
            stack.push((long) val);
        }
    }
    
    public void pop() {
        if (stack.peek() < min) {
            min = 2 * min - stack.peek();
        }
        stack.pop();
    }
    
    public int top() {
        if (stack.peek() < min) {
            return (int) min;
        }
        return  stack.peek().intValue();
    }
    
    public int getMin() {
        return (int) min;
    }
}
