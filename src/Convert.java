
public class Convert {
	
 
    static String infixToPostfix(String infix) {
    	
        final String operators = "-+/*^";
        Queue queue = new Queue();
        Stack stack = new Stack(0);
 
        for (String token : infix.split("\\s")) {
            char c = token.charAt(0);
            int current = operators.indexOf(c);
            if (current != -1 && token.length() == 1) {
                if (stack.isEmpty())
                    stack.push(current);
                else {
                    while (!stack.isEmpty()) {
                        int prec2 = stack.peek() / 2;
                        int prec1 = current / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                        	queue.enqueue(operators.charAt(stack.pop()));
                        else break;
                    }
                    stack.push(current);
                }
            } else if (c == '(') {
                stack.push(-2);
            } else if (c == ')') {
                while (stack.peek() != -2)
                	queue.enqueue(operators.charAt(stack.pop()));
                stack.pop();
            } else {
            	queue.enqueue(token);
            }
        }
        while (!stack.isEmpty())
        	queue.enqueue(operators.charAt(stack.pop()));
        return queue.elements();
    }
}
