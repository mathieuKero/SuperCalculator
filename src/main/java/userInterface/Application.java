package userinterface;
import java.io.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

import controllers.Addition;
import controllers.Command;
import controllers.Divide;
import controllers.Invoker;
import controllers.Multiply;
import controllers.Substraction;

/**
 * Classe Application, Contient l'ensemble des actions utilisateur 
 * et permet d'appeler les différentes méthodes de calcul
 * @author MathKer
 */
public class Application {

	/**
	 * Local variable that define the scanner to get the user input
	 */
	public static Scanner scanner;
	
	/**
	 * New instance of the Invoker that rule the several commands
	 */
	public static Invoker commandManager;
	
	/**
	 * Operator for the calculator => + - / * [...]
	 */
	private transient String operator = "";
	
	/**
	 * First number in the operation, if = 0 then the number is ignored
	 */
	private transient double nbr1ToOperate = 0d;
	
	/**
	 * Second number in the operation
	 */
	private transient double nbr2ToOperate = 0d;
	
	/**
	 * Standard regex pattern 
	 */
    private transient Pattern pattern;
    
    /**
     * Standard regex matchers
     */
    private transient Matcher matcher;
    
    /**
     * Double that is stored in order to be used everywhere for the user
     */
    private transient double memo;
		
	/**
	 * Default Constructor
	 */
	public Application() { /* Empty constructor */ }
	
	/**
	 * Main Methods which launch the applications
	 * @param args Array of String
	 */
	public static void main(final String[] args) {
		scanner = new Scanner(System.in);
		commandManager = new Invoker();
		final Application app = new Application();
		app.mainMessage();
	}

	
	/**
	 * Method which launch the Addition / Substraction / Multiply / Divide, 
	 * depending of the user input
	 * @author Mathieu K
	 */
	public void mainMessage() { 
	
		boolean continueTreatment = true;
		
		do{
			displayMenu();
			
			Boolean toProcess = true;
			final String userText = scanner.nextLine();
	        if(userText.matches("^(\\d*|MEMO|memo)([\\/\\+\\*\\-\\^]|sqrt)(\\d*|MEMO|memo)$")) {
	        	        	
	        	pattern = Pattern.compile("^(\\d+|MEMO|memo)");
	        	matcher = pattern.matcher(userText);
	        	if(matcher.find()) {

	        		if(matcher.group(0).equals("MEMO") || matcher.group(0).equals("memo")) {
		        		nbr1ToOperate = memo;
	        		}else {
	        			nbr1ToOperate = Double.parseDouble(matcher.group(0));
	        		}
	        	}else {
	        		if(commandManager.checkHistoryNotNull()) {
	        			System.out.println("Vous n'avez pas d'historique de calcul");
	        			toProcess = false;
	        		}else {
	        			nbr1ToOperate = 0;
	        		}
	        	}
	        	
	        	if(toProcess) {
	
	            	pattern = Pattern.compile("(\\d*|MEMO|memo)$");
	            	matcher = pattern.matcher(userText);
	        	    if(matcher.find()) {
	        	    	if(matcher.group(0).equals("MEMO") || matcher.group(0).equals("memo")) {
		        			nbr2ToOperate = memo;
		        		}else {
			        	    nbr2ToOperate = Double.parseDouble(matcher.group(0));
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
	        	switch(userText.toUpperCase(Locale.US)) {
		        	case "QUIT":
		        		continueTreatment = false;
		        		break;
		        	case "MEMO":
		        		System.out.println("Veuillez rentrer une valeur pour la variable temporaire :");
		    			final String tmpMemo = scanner.nextLine();
		    			try {
		        			memo = Double.parseDouble(tmpMemo);
		    			} catch(NumberFormatException ex) {
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
		
		Addition add;
		
		if(nbr1ToOperate == 0) {
			add = new Addition(commandManager.getValueFromPreviousCommand());	
		}else {
			add = new Addition(nbr1ToOperate);
		}
		
		commandManager.doCommand(add, nbr2ToOperate);
		System.out.println(add.toString());
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void substraction() {
		
		Substraction sub;
		
		if(nbr1ToOperate == 0) {
			sub = new Substraction(commandManager.getValueFromPreviousCommand());	
		}else {
			sub = new Substraction(nbr1ToOperate);
		}
		
		commandManager.doCommand(sub, nbr2ToOperate);
		System.out.println(sub.toString());
	}
	
	/**
	 * Method which multiply two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void multiply() {
		
		Multiply mul;
		
		if(nbr1ToOperate == 0) {
			mul = new Multiply(commandManager.getValueFromPreviousCommand());	
		}else {
			mul = new Multiply(nbr1ToOperate);
		}
		
		commandManager.doCommand(mul, nbr2ToOperate);
		System.out.println(mul.toString());
	}
	
	/**
	 * Method which divide two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void divide() {
		
		Divide div;
		
		if(nbr1ToOperate == 0) {
			div = new Divide(commandManager.getValueFromPreviousCommand());	
		}else {
			div = new Divide(nbr1ToOperate);
		}
		
		commandManager.doCommand(div, nbr2ToOperate);
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
	
	/**
	 * Display the current historic
	 */
	public void displayHistoric() {
		final 	ArrayList<Command> listCommand = commandManager.getHitsoric();
		for (final Command command : listCommand) {
			System.out.println(command.toString());
		}
	}
	
	/**
	 * Display the menue
	 */
	public void displayMenu() {
		System.out.println("Calculatrice, Liste des actions possibles :"
				+ "\n + - Addition"
				+ "\n - - Soustraction"
				+ "\n * - Multiplication"
				+ "\n / - Division"
				+ "\n HIST - Historique des Calculs"
				+ "\n MEMO - Valeur enregistrée"
				+ "\n QUIT - Quitter ");
	}
}
