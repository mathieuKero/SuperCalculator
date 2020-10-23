package controllers;

public interface Command {
	
	double redo(final double value);
	
	String toString();
	
	double getValue();
}
