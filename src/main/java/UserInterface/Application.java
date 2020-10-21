package userInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Scanner;

import controllers.Addition;
import controllers.Invoker;
import controllers.Substraction;

public class Application {

	public static Scanner scanner;
	public static String stringNumber1;
	public static String stringNumber2;
	public static Invoker commandManager;
	
	/**
	 * Main Methods which launch the applications
	 * @param args Array of String
	 */
	public static void main(String[] args) {	
		commandManager = new Invoker();
		MainMessage();
	}
	
	/**
	 * Method which launch the Addition or Substraction, depending of the user input
	 * @author Mathieu K
	 */
	public static void MainMessage() {
		boolean continueTreatment = true;
		
		do{
			
			System.out.println("Calculatrice, sélectionnez votre menu :\n 1. Addition\n 2. Soustraction\n 3. Quitter ");

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
		        	
		        	case 3 :
		        		continueTreatment = false;
		        		
		        	default:
		        }
		    } catch (NumberFormatException nfe) {}
		    
		}while(continueTreatment);
	}

	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public static void addition() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
	    } catch (NumberFormatException nfe) {}
    	
    	Addition add = new Addition(doubleNumber1, doubleNumber2);
    	System.out.println(String.format("%s + %s = %s", 
    			doubleNumber1, 
    			doubleNumber2, 
    			commandManager.doCommand(add)));
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public static void substraction() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
	    } catch (NumberFormatException nfe) {}
    	
    	Substraction sub = new Substraction(doubleNumber1, doubleNumber2);
    	System.out.println(String.format("%s + %s = %s", 
    			doubleNumber1, 
    			doubleNumber2, 
    			commandManager.doCommand(sub)));
	}
	
	public static void displayCalculMessage() {
		System.out.println("1er nombre : ");
		stringNumber1 = scanner.nextLine();
		System.out.println("2eme nombre : ");
		stringNumber2 = scanner.nextLine();
	}
}
