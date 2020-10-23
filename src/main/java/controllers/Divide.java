package controllers;

/**
 * Addition Class
 * Allow user to divide two numbers
 * @author Mathieu K
 */
public class Divide implements Command{

    /** Current value (to add a other) */
    private transient double value;

    /** Value to add at current */
    private transient double divValue;
    
    /**
     * Default Constructor.
     * @param doubleNumber the current value.
     */
    public Divide(final double doubleNumber) {
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
    public double redo(final double addValue) {
		this.displayedValue = this.value;
        this.divValue = addValue;

        if(this.divValue == 0) {
        	System.out.println("Impossible de diviser par 0");
        }else {
            this.value /= this.divValue;
        }
        
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("%s / %s = %s", displayedValue , divValue, value);
	}
}
