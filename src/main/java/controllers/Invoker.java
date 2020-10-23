package controllers;

import java.util.ArrayList;

/**
 * Invoker that control all of the controls (add / sub / div / mul)
 * When a control is created, the invoker class will dispatch the order to the corresponding command
 * @author Mathieu K
 */
public class Invoker {
 
	/**
	 * List of commands that are stored in order to get the history
	 */
	final private ArrayList<Command> listCommands;
	
	/**
	 * Create a new instance of the Invoker class
	 */
	public Invoker() {
		listCommands = new ArrayList<>();
	}
	
	/**
	 * Call the command method for all the inherited classes.
	 * @param command command that will be managed
	 * @param value command that will be managed
	 */
	public void doCommand(final Command command, double value) {
		command.redo(value);
		listCommands.add(command);
	}

	/**
	 * Return an instance of historic
	 * @return list of Commands
	 */
	public ArrayList<Command> getHitsoric() {
		return this.listCommands;
	}

	public Command getPreviousCommand() {
		return this.listCommands.get(this.listCommands.size() - 1);
	}
}
