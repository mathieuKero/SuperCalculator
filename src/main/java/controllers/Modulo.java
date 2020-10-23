package controllers;

/**
 * Modulo Class
 * Allow user to Modulo two numbers
 * @author Mathieu K
 */
public class Modulo implements Command{


    /** Current value (to add a other) */
    private transient double value;

    /** Value to modulo at current */
    private transient double modValue;
    
    /**
     * Default Constructor.
     * @param doubleNumber the current value.
     */
    public Modulo(final double doubleNumber) {
        this.value = doubleNumber;
    }
    
    /**
	 * @return the value
	 */
    @Override
	public double getValue() {
		return value;
	}

	@Override
    public double redo(final double modValue) {
        this.modValue = modValue;

        this.value %= this.modValue;
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s % %s = %s", value - modValue , modValue, value);
	}
}
