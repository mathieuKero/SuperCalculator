package controllers;

/**
 * Substraction Class
 * Allow user to substract two numbers
 * @author Mathieu K
 */
public class Substraction implements Command{
	
	/** Current value (to add a other) */
    private transient double value;

    /** Value to add at current */
    private transient double subValue;
    
    /**
     * Default Constructor.
     * @param a the current value.
     */
    public Substraction(final double doubleNumber) {
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
        this.subValue = addValue;

        this.value -= this.subValue;
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s - %s = %s", value - subValue , subValue, value);
	}
}
