package userInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

import controllers.Addition;
import controllers.Command;
import controllers.Divide;
import controllers.Invoker;
import controllers.Multiply;
import controllers.Substraction;

public class Application {

	public static Scanner scanner;
	public static String stringNumber1;
	public static String stringNumber2;
	public static Invoker commandManager;
	
	private String operator = "";
	private double firstNumber = 0;
	private double secondNumber = 0;
	private Object object;
	
    private Pattern pattern;
    private Matcher matcher;
    
    private double memo;
		
	/**
	 * Default Constructor
	 */
	public Application() { /* Empty constructor */ }
	
	/**
	 * Main Methods which launch the applications
	 * @param args Array of String
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		commandManager = new Invoker();
		Application app = new Application();
		app.MainMessage();
	}

	
	/**
	 * Method which launch the Addition / Substraction / Multiply / Divide, depending of the user input
	 * @author Mathieu K
	 */
	public void MainMessage() { 
	
		boolean continueTreatment = true;
		
		do{
			System.out.println("Calculatrice, Liste des actions possibles :"
					+ "\n + - Addition"
					+ "\n - - Soustraction"
					+ "\n * - Multiplication"
					+ "\n / - Division"
					+ "\n HIST - Historique des Calculs"
					+ "\n MEMO - Valeur enregistrée"
					+ "\n QUIT - Quitter ");
			
			Boolean toProcess = true;
			String userText = scanner.nextLine();
	        if(userText.matches("^(\\d*|MEMO|memo)([\\/\\+\\*\\-\\^]|sqrt)(\\d*|MEMO|memo)$")) {
	        	        	
	        	pattern = Pattern.compile("^(\\d+|MEMO|memo)");
	        	matcher = pattern.matcher(userText);
	        	if(matcher.find()) {
	        		
	        		String tmp = matcher.group(0);
	        		if(matcher.group(0).equals("MEMO") || matcher.group(0).equals("memo")) {
		        		firstNumber = memo;
	        		}else {
	        			firstNumber = Double.parseDouble(matcher.group(0));
	        		}
	        	}else {
	        		if(commandManager.getHitsoric().size() != 0) {
	        			firstNumber = 0;
	        		}else {
	        			System.out.println("Vous n'avez pas d'historique de calcul");
	        			toProcess = false;
	        		}
	        	}
	        	
	        	if(toProcess) {
	
	            	pattern = Pattern.compile("(\\d*|MEMO|memo)$");
	            	matcher = pattern.matcher(userText);
	        	    if(matcher.find()) {
	        	    	if(matcher.group(0).equals("MEMO") || matcher.group(0).equals("memo")) {
		        			secondNumber = memo;
		        		}else {
			        	    secondNumber = Double.parseDouble(matcher.group(0));
		        		}
		        	}
	        	    
	            	pattern = Pattern.compile("([\\/\\+\\*\\-\\^]|sqrt)");
	            	matcher = pattern.matcher(userText);
	            	if(matcher.find()) {
	            		operator = matcher.group(0);
	            	
		            	switch (operator) {
		    	    		case "+":
		    	    			addition();
		    	    			break;
		    	    		case "-":
		    	    			substraction();
		    	    			break;
		    	    		case "/":
		    	    			divide();
		    	    			break;
		    	    		case "*":
		    	    			multiply();
		    	    			break;
		    	    		case "^":
		    	    			square();
		    	    			break;
		    	    		case "sqrt":
		    	    			squareOut();
		    	    			break;
				        		
				        	default:
				        		break;
			        	}	
	            	}
	            	
	        	}
	        }else if(userText.matches("^(quit|QUIT|MEMO|memo|HIST|hist)$")) {
	        	switch(userText.toUpperCase()) {
		        	case "QUIT":
		        		continueTreatment = false;
		        		break;
		        	case "MEMO":
		        		System.out.println("Veuillez rentrer une valeur pour la variable temporaire :");
		    			String tmpMemo = scanner.nextLine();
		    			try {
		        			memo = Double.parseDouble(tmpMemo);
						} catch (Exception e) {
							System.out.println("Merci de renseigner une valeur décimale");
						}
		        		break;
		        	case "HIST":
		        		displayHistoric();
		        		break;
	        	}
	        }
		}while(continueTreatment);
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void addition() {
		
		Addition add = null;
		
		if(firstNumber != 0) {
			add = new Addition(firstNumber);
		}else {
			add = new Addition(commandManager.getPreviousCommand().getValue());	
		}
		
		commandManager.doCommand(add, secondNumber);
		System.out.println(add.toString());
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void substraction() {
		
		Substraction sub = null;
		
		if(firstNumber != 0) {
			sub = new Substraction(firstNumber);
		}else {
			sub = new Substraction(commandManager.getPreviousCommand().getValue());	
		}
		
		commandManager.doCommand(sub, secondNumber);
		System.out.println(sub.toString());
	}
	
	/**
	 * Method which multiply two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void multiply() {
		
		Multiply mul = null;
		
		if(firstNumber != 0) {
			mul = new Multiply(firstNumber);
		}else {
			mul = new Multiply(commandManager.getPreviousCommand().getValue());	
		}
		
		commandManager.doCommand(mul, secondNumber);
		System.out.println(mul.toString());
	}
	
	/**
	 * Method which divide two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void divide() {
		
		Divide div = null;
		
		if(firstNumber != 0) {
			div = new Divide(firstNumber);
		}else {
			div = new Divide(commandManager.getPreviousCommand().getValue());	
		}
		
		commandManager.doCommand(div, secondNumber);
		System.out.println(div.toString());
	}
	
	/**
	 * Method witch square the first number depends on the second
	 * @author Mathieu K
	 */
	public void square() {
		
	}
	
	/**
	 * Method witch squareOut the number
	 * @author Mathieu K
	 */
	public void squareOut() {
		
	}
	
	public void displayHistoric() {
		ArrayList<Command> listCommand = commandManager.getHitsoric();
		for (Command command : listCommand) {
			System.out.println(command.toString());
		}
	}
}
