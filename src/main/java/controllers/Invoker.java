package controllers;

public class Invoker {
 
	public double doCommand(Command command) {
		return command.calculate();
	}
}

