package controllers;

public class Invoker {
 
	public double doCommand(Command command) {
		return command.calculate();
	}
	
	//TODO générer une méthode d'affichage d'historique
}

