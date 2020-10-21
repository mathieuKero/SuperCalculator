package userInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Scanner;

import controllers.Addition;
import controllers.Substraction;

public class Application {

	public static Scanner scanner;
	public static String stringNumber1;
	public static String stringNumber2;
	
	public static void main(String[] args) {	
		MainMessage();
	}
	
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

	
	public static void addition() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
	    } catch (NumberFormatException nfe) {}
    	
    	Addition add = new Addition();
    	System.out.println(String.format("%s + %s = %s", doubleNumber1, doubleNumber2, add.calculate(doubleNumber1, doubleNumber2)));
	}
	
	public static void substraction() {
		
    	Double doubleNumber1 = null;
    	Double doubleNumber2 = null;
    	
    	displayCalculMessage();
    	
    	try {
    		doubleNumber1 = Double.parseDouble(stringNumber1);
    		doubleNumber2 = Double.parseDouble(stringNumber2);
	    } catch (NumberFormatException nfe) {}
    	
    	Substraction sub = new Substraction();
    	System.out.println(String.format("%s + %s = %s", doubleNumber1, doubleNumber2, sub.calculate(doubleNumber1, doubleNumber2)));
	}
	
	public static void displayCalculMessage() {
		System.out.println("1er nombre : ");
		stringNumber1 = scanner.nextLine();
		System.out.println("2eme nombre : ");
		stringNumber2 = scanner.nextLine();
	}
}
