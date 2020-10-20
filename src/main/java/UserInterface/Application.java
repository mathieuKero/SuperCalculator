package UserInterface;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		MainMessage();
		
		
		
	}
	
	public static void MainMessage() {
		boolean continueTreatment = true;
		
		do{
			
			System.out.println("Calculatrice, sélectionnez votre menu :\n 1. Addition\n 2. Soustraction ");

	        Scanner in = new Scanner(System.in);
	    	String userChoice = in.nextLine();
	    	
		    try {
		    	int userChoiceInt = Integer.parseInt(userChoice);
		        
		        switch(userChoiceInt) {
		        	case 1: 
				        continueTreatment = false;
		        		break;
		        		
		        	case 2:
				        continueTreatment = false;
		        		break;
		        		
		        	default:
		        }
		    } catch (NumberFormatException nfe) {}
		    
		}while(continueTreatment);
	}

}
