import java.util.ArrayList;
import java.util.Scanner;


public class Parse {

	public static String ParseExpression(String infix) {
		
		String[] tokenized = infix.replaceAll("\\s+","").split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])|(?=[a-z])|(?=\\()|(?<=\\)\\d)");
		ArrayList<String> list = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		String listString = "";
		
		for (int i = 0; i < tokenized.length; i++) {
			if(tokenized[i].trim().length() > 0) {
				if(Character.isLetter(tokenized[i].charAt(0))){

					if(!isOperator(list.get(list.size()-1))){
						list.add("*");
					}
					System.out.println("Please enter a number for the variable '" + tokenized[i] + "'");
					list.add(in.next());
					if(!isOperator(tokenized[i+1])){
						list.add("*");							
					}
				}else {
					list.add(tokenized[i]);
				}
			}
			
		}
		in.close();
		for(String token1 : list){
			listString += token1;
		}
		
		return listString;
	}
	
	private static boolean isOperator(String token) {
	    return (
	        token.equals("+")
	        || token.equals("-")
	        || token.equals("*")
	        || token.equals("/")
	        || token.equals("^")
	    );
	}

}
