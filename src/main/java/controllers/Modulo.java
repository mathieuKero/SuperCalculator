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
     * Origin value to display
     */
    private transient double displayedValue;
    
    
    /**
	 * @return the value
	 */
    @Override
	public double getValue() {
		return value;
	}

	@Override
    public double redo(final double modValue) {
		this.displayedValue = this.value;
        this.modValue = modValue;

        this.value = this.value % this.modValue;
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s %% %s = %s", displayedValue , modValue, value);
	}
}
