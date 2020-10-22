package controllers;

/**
 * Addition Class
 * Allow user to addition two numbers
 * @author Mathieu K
 */
public class Addition implements Command{
	
	/**
	 * First number to add
	 */
	private double nbr1;
	
	/**
	 * Second number to add
	 */
	private double nbr2;
	
	/**
	 * Result of the calcul
	 */
	private double result;
	
	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	/**
	 * @return the nbr1
	 */
	public double getNbr1() {
		return nbr1;
	}

	/**
	 * @param nbr1 the nbr1 to set
	 */
	public void setNbr1(double nbr1) {
		this.nbr1 = nbr1;
	}

	/**
	 * @return the nbr2
	 */
	public double getNbr2() {
		return nbr2;
	}

	/**
	 * @param nbr2 the nbr2 to set
	 */
	public void setNbr2(double nbr2) {
		this.nbr2 = nbr2;
	}
	
	/**
	 * Create a new instance of Addition
	 * @param nbr1 First number to add
	 * @param nbr2 Second number to add
	 */
	public Addition(double nbr1, double nbr2) {
		super();
		this.nbr1 = nbr1;
		this.nbr2 = nbr2;
		this.result = 0;
	}

	/**
	 * Addition Method which addition two numbers 
	 */
	@Override
	public void calculate() {
		result = nbr1 + nbr2;
	}
	
	@Override
	public void revert() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return String.format("%s + %s = %s", nbr1, nbr2, result);
	}
}
