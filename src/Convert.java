
public class Convert {
	
 
    static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        Queue sa = new Queue();
        //StringBuilder sb = new StringBuilder();
        Stack s = new Stack(0);
 
        for (String token : infix.split("\\s")) {
            char c = token.charAt(0);
            int idx = ops.indexOf(c);
            if (idx != -1 && token.length() == 1) {
                if (s.isEmpty())
                    s.push(idx);
                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                        	sa.enqueue(ops.charAt(s.pop()));
                            //sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2);
            } else if (c == ')') {
                while (s.peek() != -2)
                	sa.enqueue(ops.charAt(s.pop()));
                    //sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            } else {
            	sa.enqueue(token);
                //sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
        	sa.enqueue(ops.charAt(s.pop()));
            //sb.append(ops.charAt(s.pop())).append(' ');
        return sa.elements();
    }
}
