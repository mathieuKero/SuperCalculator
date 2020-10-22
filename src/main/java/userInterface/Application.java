package userInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

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

	/**
	 * Default Constructor
	 */
	public Application() { /* Empty constructor */ }
	/**
	 * Main Methods which launch the applications
	 * @param args Array of String
	 */
	public static void main(String[] args) {	
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
			
			System.out.println("Calculatrice, s�lectionnez votre action :"
					+ "\n 1. Addition"
					+ "\n 2. Soustraction"
					+ "\n 3. Multiplication"
					+ "\n 4. Division"
					+ "\n 5. Historique des Calculs"
					+ "\n 6. Quitter ");

			scanner = new Scanner(System.in);
	    	String userChoice = scanner.nextLine();
	    	
		    try {
		    	int userChoiceInt = Integer.parseInt(userChoice);
		        
		        switch(userChoiceInt) {
		        	case 1:
				        addition();
		        		break;
		        		
					case 2:			        
				        substraction();
		        		break;
		        		
					case 3:		    
					    multiply();
						break;
						
					case 4:
					    divide();
						break;
						        	
					case 5 :
		        		displayHistoric();
		        		break; 
		        		
					case 6 :
		        		continueTreatment = false;
		        		break;
		        		
		        	default:
		        		break;
		        }
		    } catch (NumberFormatException nfe) {}
		    
		}while(continueTreatment);
	}

	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void addition() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
    		
        	Addition add = new Addition(doubleNumber1, doubleNumber2);
        	commandManager.doCommand(add);
        	System.out.println(add.toString());
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Merci de renseigner des nombres valides");
	    }
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void substraction() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
    		
        	Substraction sub = new Substraction(doubleNumber1, doubleNumber2);
        	commandManager.doCommand(sub);
        	System.out.println(sub.toString());
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Merci de renseigner des nombres valides");
	    }
	}
	
	/**
	 * Method which multiply two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void multiply() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
    		
    		Multiply multi = new Multiply(doubleNumber1, doubleNumber2);
        	commandManager.doCommand(multi);
        	System.out.println(multi.toString());
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Merci de renseigner des nombres valides");
	    }   	
	}
	
	/**
	 * Method which divide two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public void divide() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
    		
        	Divide div = new Divide(doubleNumber1, doubleNumber2);
        	commandManager.doCommand(div);
        	System.out.println(div.toString());
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Merci de renseigner des nombres valides");
	    }
	}
	
	public void displayCalculMessage() {
		System.out.println("1er valeur : ");
		stringNumber1 = scanner.nextLine();
		System.out.println("2eme valeur : ");
		stringNumber2 = scanner.nextLine();
	}
	
	public void displayHistoric() {
		ArrayList<Command> listCommand = commandManager.getHitsoric();
		for (Command command : listCommand) {
			System.out.println(command.toString());
		}
	}
}
