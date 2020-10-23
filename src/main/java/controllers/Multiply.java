package controllers;

/**
 * Multiply Class
 * Allow user to multiply two numbers
 * @author MathKer
 */
public class Multiply implements Command{

	/** Current value (to add a other) */
    private transient double value;

    /** Value to add at current */
    private transient double mulValue;
    
    /**
     * Default Constructor.
     * @param doubleNumber the current value.
     */	
    public Multiply(final double doubleNumber) {
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
       this.mulValue = addValue;

       this.value *= this.mulValue;
       return this.value;
   }
   	
   	@Override
   	public String toString() {
   		return String.format("%s * %s = %s", value - mulValue , mulValue, value);
   	}
}
