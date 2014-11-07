import java.util.StringTokenizer;


public class Evaluate {
	
	private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/', POW = '^';
	
	static int calculate(String expr) { 
		Stack stack = new Stack(0);
	    int op1, op2, result = 0;
	    String token;
	    StringTokenizer tokenizer = new StringTokenizer(expr);
	
	    while (tokenizer.hasMoreTokens()) {
	        token = tokenizer.nextToken();
	
	        if (isOperator(token)) {
	            op2 = ((Integer) stack.pop()).intValue();
	            op1 = ((Integer) stack.pop()).intValue();
	            result = evalSingleOp(token.charAt(0), op1, op2);
	            stack.push(new Integer(result));
	        }
	        else
	            stack.push(new Integer(Integer.parseInt(token)));
	    }
	
	    result = ((Integer) stack.pop()).intValue();
	    return result;
	}  
	
	private static boolean isOperator(String token) {
	    return (
	        token.equals("+")
	            || token.equals("-")
	            || token.equals("*")
	            || token.equals("/")
	            || token.equals("^"));
	}
	
	private static int evalSingleOp(char operation, int op1, int op2) {
        int result = 0;

        switch (operation) {
            case ADD :
                result = op1 + op2;
                break;
            case SUBTRACT :
                result = op1 - op2;
                break;
            case MULTIPLY :
                result = op1 * op2;
                break;
            case DIVIDE :
                result = op1 / op2;
                break;
            case POW : 
            	result = (int) Math.pow(op1,op2);
        }
        
        

        return result;
    }
}
