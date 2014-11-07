
public class Main {
	public static void main(String[] args) {
       //String infix = "3 + 4 * 2 / ( 1 - 5 ) + 2 - 3";
        //String infix = "(5 + 3) - 10*(5- 3 ) + 75 + 5 ^ 2 * ( 2 + 3 )";
		String infix = "(5+ 3) * 2 - 10 + 4 / (4-1)";
        //String infix = "x ^ y / (5 * z) + 10";
		//String infix = "10 * (5 - 3) + 75  /  5 ^ 2 + ( 2 + 3)";
		//String infix = "8 / 4 + 7 * ( 5 + 2) - 33 * 2";
        System.out.printf("infix:   %s%n", infix);
        System.out.printf("postfix: %s%n", Convert.infixToPostfix(infix));
        System.out.println(Evaluate.calculate(Convert.infixToPostfix(infix)));
    }

}
