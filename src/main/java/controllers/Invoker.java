package controllers;

import java.util.ArrayList;

public class Invoker {
 
	private ArrayList<Command> listCommands;
	
	public Invoker() {
		listCommands = new ArrayList<Command>();
	}
	
	public void doCommand(Command command) {
		command.calculate();
		listCommands.add(command);
	}

	public ArrayList<Command> getHitsoric(){
		return this.listCommands;
	}
}
