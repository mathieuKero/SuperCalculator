package controllers;

public class Invoker {
 
	public double doCommand(Command command) {
		return command.calculate();
	}
	
	//TODO g�n�rer une m�thode d'affichage d'historique
}

