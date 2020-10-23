package controllers;

/**
 * Modulo Class
 * Allow user to SquareOut two numbers
 * @author Mathieu K
 */
public class SquareOut implements Command{


    /** Current value (to add a other) */
    private transient double value;
    
    /**
     * Default Constructor.
     * @param doubleNumber the current value.
     */
    public SquareOut() { /* Empty constructor */ }
    
    /**
	 * @return the value
	 */
    @Override
	public double getValue() {
		return value;
	}

	@Override
    public double redo(final double sqrOutValue) {
        this.value = Math.sqrt(sqrOutValue);
		
        return this.value;
    }
	
	@Override
	public String toString() {
		return String.format("Racine(%s) = %s", value * value , value);
	}
}