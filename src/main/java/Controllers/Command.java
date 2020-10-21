package controllers;

public interface Command {

	double calculate();
	
	void revert();
}
