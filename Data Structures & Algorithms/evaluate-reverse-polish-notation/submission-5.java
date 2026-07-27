class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String ch: tokens) {
            if (!ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/")) {
                stack.push(Integer.parseInt((ch)));
            }

            else if (!stack.isEmpty()) {
                int a = stack.pop();
                int b = stack.pop();

                if (ch.equals("+")) {
                    stack.push(a+b);
                }
                else if (ch.equals("-")) {
                    stack.push(b-a);
                }
                else if (ch.equals("*")) {
                    stack.push(a * b);
                }
                else if (ch.equals("/")) {
                    if (a == 0 || b == 0) {
                        stack.push(0);
                    }
                    else {
                        stack.push(b/a);
                    }
                }
            }
        }
        return stack.peek();
        
    }
}
