import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class Driver {

	public static void read(){
		
		try {
			String infix;
			String postfix;
		    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		    PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		    System.setOut(out);
		    
		    while ((infix = in.readLine()) != null){
		    	
		    	System.out.printf("Infix:    %s%n", infix);
		    	postfix = Convert.infixToPostfix(infix);
		    	System.out.printf("Postfix: %s%n", postfix);
		    	System.out.printf("Evaluation: %s%n" , Evaluate.calculate(postfix));
		    	System.out.println("**********************************");
		    }
		    in.close();
		    out.close();
		} catch (IOException e) {
		}
	}
}
