package controllers;

/**
 * Modulo Class
 * Allow user to Square two numbers
 * @author Mathieu K
 */
public class Square implements Command{


    /** Current value (to add a other) */
    private transient double value;

    /** Value to modulo at current */
    private transient double sqrValue;
    
    /**
     * Origin value to display
     */
    private transient double displayedValue;
    
    /**
     * Default Constructor.
     * @param doubleNumber the current value.
     */
    public Square(final double doubleNumber) {
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
    public double redo(final double sqrValue) {
		double currentValue = this.value;
		this.displayedValue = currentValue;
		this.sqrValue = sqrValue;
		for (int i = 0; i < sqrValue - 1; i++) {
	        this.value *= currentValue;
		}
		
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s ^ %s = %s", displayedValue , sqrValue, value);
	}
}