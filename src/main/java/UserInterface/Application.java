package UserInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Scanner;

import Controllers.Addition;
import Controllers.Substraction;


/**
 * Core Class which launch the SuperCalculator Application 
 * @author Mathieu K
 */
public class Application {

	public static Scanner scanner;
	
	/**
	 * Main Methods which launche the applications
	 * @param args Array of String
	 */
	public static void main(String[] args) {	
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
				        AdditionMessage();
		        		break;
		        		
		        	case 2:
				        
				        SubstractionMessage();
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
	public static void AdditionMessage() {
		System.out.println("1er nombre : ");
    	String number1 = scanner.nextLine();
		System.out.println("2eme nombre : ");
    	String number2 = scanner.nextLine();
    	
    	Double nbr1 = null;
    	Double nbr2 = null;
    	
    	try {
    		nbr1 = Double.parseDouble(number1);
    		nbr2 = Double.parseDouble(number2);
	    } catch (NumberFormatException nfe) {}
    	
    	Addition add = new Addition();
    	System.out.println(add.Addition(nbr1, nbr2));
	}
	
	/**
	 * Method which add two numbers and print the result to the user 
	 * @author Mathieu K
	 */
	public static void SubstractionMessage() {
		System.out.println("1er nombre : ");
    	String number1 = scanner.nextLine();
		System.out.println("2eme nombre : ");
    	String number2 = scanner.nextLine();
    	
    	Double nbr1 = null;
    	Double nbr2 = null;
    	
    	try {
    		nbr1 = Double.parseDouble(number1);
    		nbr2 = Double.parseDouble(number2);
	    } catch (NumberFormatException nfe) {}
    	
    	Substraction sub = new Substraction();
    	System.out.println(sub.Substraction(nbr1, nbr2));
	}
}
