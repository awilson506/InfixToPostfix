import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Driver {

	public static void read(){
		try {
		    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		    String infix;
		    while ((infix = in.readLine()) != null){
		    	System.out.printf("infix:    %s%n", infix);
		    	System.out.printf("postfix: %s%n", Convert.infixToPostfix(infix));
		    	System.out.printf("Evaluation: %s%n" , Evaluate.calculate(Convert.infixToPostfix(infix)));
		    	System.out.println("**********************************");
		    }
		    in.close();
		} catch (IOException e) {
		}
	}
}
