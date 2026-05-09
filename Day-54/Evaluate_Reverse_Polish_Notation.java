class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b); // truncates toward 0
                    break;
                }

                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
