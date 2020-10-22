package controllers;

public interface Command {

	void calculate();
	
	void revert();
	
	String toString();
}
