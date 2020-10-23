package controllers;

/**
 * Addition Class
 * Allow user to addition two numbers
 * @author Mathieu K
 */
public class Addition implements Command{

    /** Current value (to add a other) */
    private transient double value;

    /** Value to add at current */
    private transient double addValue;
    
    /**
     * Default Constructor.
     * @param a the current value.
     */
    public Addition(final double doubleNumber) {
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
    public double redo(final double addValue) {
        this.addValue = addValue;

        this.value += this.addValue;
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s + %s = %s", value - addValue , addValue, value);
	}
}
