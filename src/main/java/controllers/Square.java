package controllers;

public class Square implements Command {
	@Override
	public void calculate() {

	}

	@Override
	public void revert() {
		// TODO: To Complete
	}

	@Override
	public String toString() { return String.format("(%s * %s) * %d"); }
}
